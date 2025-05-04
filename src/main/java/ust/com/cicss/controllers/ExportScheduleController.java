package ust.com.cicss.controllers;

import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ust.com.cicss.services.ExportScheduleService;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/export")
public class ExportScheduleController {
    @Autowired
    ExportScheduleService service;

    @GetMapping()
    public void export(HttpServletResponse response) {
        try {
            //Get schedule_id from Map
//            String scheduleId= schedule_id.get("schedule_id");

            // Get the workbook
            Workbook wb = service.convertJSONToExcel();

            // Set proper content type and headers
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("Content-Disposition", "attachment; filename=schedule.xlsx");
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Expires", "0");

            // Write to the response output stream
            try (FileOutputStream out = new FileOutputStream("schedule.xlsx")) {
                wb.write(out);
            }

            // Close the workbook to free resources
            wb.close();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to generate Excel file: " + e.getMessage());
            } catch (IOException ioEx) {
                // Log fallback error
                System.err.println("Failed to send error response: " + ioEx.getMessage());
            }
        }
    }
}
