package ust.com.cicss.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ust.com.cicss.dao.ScheduleRepository;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class ExportScheduleService {
    @Autowired
    private ScheduleRepository repo;
    private ObjectMapper mapper = new ObjectMapper();

    public ExportScheduleService() {
    }

    static final Map<String, Integer> dayColMap = Map.of(
            "MONDAY", 1,
            "TUESDAY", 2,
            "WEDNESDAY", 3,
            "THURSDAY", 4,
            "FRIDAY", 5,
            "SATURDAY",6
    );

//    static int getTimeRowIndex(String time) {
//        int startTime = Integer.parseInt(time);
//        return switch (startTime) {
//            case 700 -> 1;
//            case 730 -> 2;
//            case 800 -> 3;
//            case 830 -> 4;
//            case 900 -> 5;
//            case 930 -> 6;
//            case 1000 -> 7;
//            case 1030 -> 8;
//            case 1100 -> 9;
//            case 1130 -> 10;
//            case 1200 -> 11;
//            case 1230 -> 12;
//            case 1300 -> 13;
//            case 1330 -> 14;
//            case 1400 -> 15;
//            case 1430 -> 16;
//            case 1500 -> 17;
//            case 1530 -> 18;
//            case 1600 -> 19;
//            case 1630 -> 20;
//            case 1700 -> 21;
//            case 1730 -> 22;
//            case 1800 -> 23;
//            case 1830 -> 24;
//            case 1900 -> 25;
//            case 1930 -> 26;
//            case 2000 -> 27;
//            case 2030 -> 28;
//            case 2100 -> 29;
//            default -> -1; // out of range
//        };
//    }

//    static String convertTime(String time) {
//        int t = Integer.parseInt(time);
//        int hour = t / 100;
//        int minute = t % 100;
//        String suffix = hour >= 12 ? "PM" : "AM";
//        if (hour > 12) hour -= 12;
//        return String.format("%d:%02d %s", hour, minute, suffix);
//    }

    static String convertTime(String time) {
        time = formatToHHmm(time);
        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("H:mm");
        DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("h:mm a");
        LocalTime parsedTime = LocalTime.parse(time, inputFormat);
        return outputFormat.format(parsedTime);
    }

    private static String formatToHHmm(String time) {
        if (time.contains(":")) return time; // already in HH:mm format

        int t = Integer.parseInt(time);
        int hour = t / 100;
        int minute = t % 100;
        return String.format("%02d:%02d", hour, minute);
    }

    private int getTimeRowIndex(String time) {
        time = formatToHHmm(time);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime base = LocalTime.of(7, 0);
        LocalTime start = LocalTime.parse(time, formatter);
        if (start.isBefore(base) || start.isAfter(LocalTime.of(21, 0))) return -1;

        long minutes = Duration.between(base, start).toMinutes();
        return (int)(minutes / 30) + 1;
    }


    public Workbook convertJSONToExcel() throws JsonProcessingException, FileNotFoundException, IOException {
        String json = repo.getSchedule();
        Map<String, Map<String, Map<String, Map<String, List<Map<String, Object>>>>>> jsonData =
                mapper.readValue(json,
                        new TypeReference<>() {});

        Workbook wb = new XSSFWorkbook();

        for(String dept: jsonData.keySet()) { //Get the department
            var yearMap = jsonData.get(dept);
            for(String year: yearMap.keySet()) { //Get the year level
                var sectionMap = yearMap.get(year);
                for(String section: sectionMap.keySet()) {  //Get the specific section
                    String sheetName = year + section;
                    Sheet sheet = wb.createSheet(sheetName);


                    // Generate time slots and populate time column (col 0) from row 1 onward
                    List<String[]> timeSlots = generateTimeSlots("07:00", "21:00", 30);
                    for (int i = 0; i < timeSlots.size(); i++) {
                        String start = timeSlots.get(i)[0];
                        String end = timeSlots.get(i)[1];
                        String timeLabel = convertTime(start) + " to " + convertTime(end);

                        Row row = sheet.createRow(i + 1); // +1 to skip header
                        row.createCell(0).setCellValue(timeLabel);
                    }

                    //header row
                    Row header = sheet.createRow(0);
                    header.createCell(0).setCellValue("TIME");
                    dayColMap.forEach((day, col) -> header.createCell(col).setCellValue(day));

                    var dayMap = sectionMap.get(section);
                    for(String dayKey: dayMap.keySet()) {
                        String day = switch(dayKey) {
                            case "M" -> "MONDAY";
                            case "T" -> "TUESDAY";
                            case "W" -> "WEDNESDAY";
                            case "TH" -> "THURSDAY";
                            case "F" -> "FRIDAY";
                            case "S" -> "SATURDAY";
                            default -> dayKey;
                        };

                        int colIndex = dayColMap.getOrDefault(day, -1);
                        if(colIndex == -1) continue;

                        List<Map<String, Object>> entries = dayMap.get(dayKey);
                        for(Map<String, Object> entry: entries) {
                            Map<String, String> timeBlock = (Map<String, String>) entry.get("timeBlock");
//                            int rowIndex = getTimeRowIndex(timeBlock.get("start"));
//                            if(rowIndex == -1) continue;
//
//                            String timeLabel = convertTime(timeBlock.get("start")) + " to " + convertTime(timeBlock.get("end"));
//                            Row row = sheet.getRow(rowIndex);
//                            if(row == null) {
//                                row = sheet.createRow(rowIndex);
//                                row.createCell(0).setCellValue(timeLabel);
//                            }

                            String start = formatToHHmm(timeBlock.get("start"));
                            String end = formatToHHmm(timeBlock.get("end"));

                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                            LocalTime startTime = LocalTime.parse(start, formatter);
                            LocalTime endTime = LocalTime.parse(end, formatter);

                            while (startTime.isBefore(endTime)) {
                                int rowIndex = getTimeRowIndex(startTime.format(formatter));
                                if (rowIndex == -1) break;

                                Row row = sheet.getRow(rowIndex);
                                if (row == null) row = sheet.createRow(rowIndex);

                                String timeLabel = convertTime(startTime.format(formatter)) + " to " +
                                        convertTime(startTime.plusMinutes(30).format(formatter));

                                // Set time label in column 0 if not already set
                                Cell timeCell = row.getCell(0);
                                if (timeCell == null || timeCell.getStringCellValue().isEmpty()) {
                                    row.createCell(0).setCellValue(timeLabel);
                                }


                                Map<String, String> course = (Map<String, String>) entry.get("course");
                                Map<String, String> room = (Map<String, String>) entry.get("room");
                                Map<String, String> tas = (Map<String, String>) entry.get("tas");

                                String tasName = (String) tas.get("tas_name");
                                String tasId = (String) tas.get("tas_id");
                                String prof = (tasName != null && !tasName.isBlank()) ? tasName : tasId;

                                String value = course.get("subjectCode") + "\n" +
                                        room.get("roomId") + "\n" +
                                        prof;

                                // Fill course details in correct day column
                                Cell cell = row.createCell(colIndex);
                                cell.setCellValue(value);

                                // Add cell styles
                                String courseType = course.get("category");
                                CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
                                String subjectCode = course.get("subjectCode");

                                if(courseType.equals("major")) {
                                    cellStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.index);
                                    cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                                    cell.setCellStyle(cellStyle);
                                } else if(subjectCode.contains("PATHFIT")) {
                                    cellStyle.setFillForegroundColor(IndexedColors.YELLOW.index);
                                    cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                                    cell.setCellStyle(cellStyle);

                                } else if(courseType.equals("gened")) {
                                    cellStyle.setFillForegroundColor(IndexedColors.BRIGHT_GREEN.index);
                                    cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                                    cell.setCellStyle(cellStyle);
                                }

                                startTime = startTime.plusMinutes(30);
                            }

//                            Map<String, String> course = (Map<String, String>) entry.get("course");
//                            Map<String, String> room = (Map<String, String>) entry.get("room");
//                            Map<String, String> tas = (Map<String, String>) entry.get("tas");
//
//                            String tasName = (String) tas.get("tas_name");
//                            String tasId = (String) tas.get("tas_id");
//                            String prof = (tasName != null && !tasName.isBlank()) ? tasName : tasId;
//
//                            String value = course.get("subjectCode") + "\n" +
//                                    room.get("roomId") + "\n" +
//                                    prof;
//
//                            Cell cell = row.createCell(colIndex);
//                            cell.setCellValue(value);
                        }
                    }
                    for (int i = 0; i <= 7; i++) sheet.autoSizeColumn(i);
                }
            }
        }

        return wb;
    }

    private List<String[]> generateTimeSlots(String startTime, String endTime, int intervalMinutes) {
        List<String[]> slots = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime start = LocalTime.parse(startTime, formatter);
        LocalTime end = LocalTime.parse(endTime, formatter);

        while (start.isBefore(end)) {
            LocalTime next = start.plusMinutes(intervalMinutes);
            slots.add(new String[]{start.toString(), next.toString()});
            start = next;
        }
        return slots;
    }
}
