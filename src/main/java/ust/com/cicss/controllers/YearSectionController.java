package ust.com.cicss.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.Table;
import ust.com.cicss.dao.YearSectionRepository;
import ust.com.cicss.models.Section;
import ust.com.cicss.models.YearSection;

@RestController
@RequestMapping("/year_sections")
@Table(name = "year_sections")
public class YearSectionController {

    @Autowired
    private YearSectionRepository repo;

    @PreAuthorize("hasAuthority('ROLE_Department_Chair') or hasAuthority('ROLE_Student') or hasAuthority('ROLE_TAS')")
    @GetMapping("/{mainDepartment}")
    public YearSection getYearSections(@PathVariable String mainDepartment){
        System.out.println("this is hit");
        
        YearSection yearSections = repo.getYearSections(mainDepartment);
        return yearSections;
    }

    @PreAuthorize("hasAuthority('ROLE_Department_Chair')")
    @PostMapping
    public void addYearSection(@RequestBody Map<String, Object> reqBody) throws JsonProcessingException  {

        // System.out.println("year section");
        // System.out.println(yearSection.getDepartment());
        // System.out.println(yearSection.getSections());
        // // System.out.println(yearSection.getSemester());

        String department = (String) reqBody.get("department");
        int semester = Integer.parseInt(reqBody.get("semester").toString());
        ObjectMapper mapper = new ObjectMapper();

//        ArrayList<Section> firstYearSections = mapper.convertValue(reqBody.get("1"), ArrayList.class);
//        ArrayList<Section> secondYearSections = mapper.convertValue(reqBody.get("2"), ArrayList.class);
//        ArrayList<Section> thirdYearSections = mapper.convertValue(reqBody.get("3"), ArrayList.class);
//        ArrayList<Section> fourthYearSections = mapper.convertValue(reqBody.get("4"), ArrayList.class);
//
//        String firstYearJson = mapper.writeValueAsString(firstYearSections);
//        String secondYearJson = mapper.writeValueAsString(secondYearSections);
//        String thirdYearJson = mapper.writeValueAsString(thirdYearSections);
//        String fourthYearJson = mapper.writeValueAsString(fourthYearSections);

        String firstYear = "";
        String secondYear = "";
        String thirdYear = "";
        String fourthYear = "";

        for (Map.Entry<String, Object> entry : reqBody.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            if (value == null || !(value instanceof List)) {
                continue;
            }

            List<Map<String, Object>> sectionList = (List<Map<String, Object>>) value;

            // Filter out entries with null section values
            List<Map<String, Object>> filteredList = sectionList.stream()
                    .filter(item -> item.get("section") != null)
                    .collect(Collectors.toList());

            String json = mapper.writeValueAsString(filteredList);

            switch (key) {
                case "1":
                    firstYear = json;
                    break;
                case "2":
                    secondYear = json;
                    break;
                case "3":
                    thirdYear = json;
                    break;
                case "4":
                    fourthYear = json;
                    break;
            }
        }



        String randomString = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
        String yearSectionId = "YS" + randomString;
        repo.deletePreviousYearSections(department);
        
        repo.insertYearSections(yearSectionId, department, semester, firstYear, secondYear, thirdYear, fourthYear);
        
        // repo.save(yearSection);
    }


}
