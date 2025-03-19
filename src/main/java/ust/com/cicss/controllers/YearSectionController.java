package ust.com.cicss.controllers;

import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.Table;
import ust.com.cicss.dao.YearSectionRepository;
import ust.com.cicss.models.Section;

@RestController
@RequestMapping("/year_sections")
@Table(name = "year_sections")
public class YearSectionController {

    @Autowired
    private YearSectionRepository repo;

    @PostMapping
    public void addYearSection(@RequestBody Map<String, Object> reqBody) throws JsonProcessingException  {

        // System.out.println("year section");
        // System.out.println(yearSection.getDepartment());
        // System.out.println(yearSection.getSections());
        // // System.out.println(yearSection.getSemester());

        String department = (String) reqBody.get("department");
        int semester = Integer.parseInt(reqBody.get("semester").toString());
        ObjectMapper mapper = new ObjectMapper();

        ArrayList<Section> firstYearSections = mapper.convertValue(reqBody.get("1"), ArrayList.class);
        ArrayList<Section> secondYearSections = mapper.convertValue(reqBody.get("2"), ArrayList.class);
        ArrayList<Section> thirdYearSections = mapper.convertValue(reqBody.get("3"), ArrayList.class);
        ArrayList<Section> fourthYearSections = mapper.convertValue(reqBody.get("4"), ArrayList.class);

        String firstYearJson = mapper.writeValueAsString(firstYearSections);
        String secondYearJson = mapper.writeValueAsString(secondYearSections);
        String thirdYearJson = mapper.writeValueAsString(thirdYearSections);
        String fourthYearJson = mapper.writeValueAsString(fourthYearSections);


        String randomString = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
        String yearSectionId = "YS" + randomString;
        repo.insertYearSections(yearSectionId, department, semester, firstYearJson, secondYearJson, thirdYearJson, fourthYearJson);
        
        // repo.save(yearSection);
    }


}
