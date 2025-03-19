package ust.com.cicss.dao;


import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import ust.com.cicss.models.Section;
import ust.com.cicss.models.YearSection;

@Repository
public interface YearSectionRepository extends JpaRepository<YearSection, String> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO year_sections (year_section_id, department, semester, first_year_sections, second_year_sections, third_year_sections, fourth_year_sections) VALUES " + 
    "(?1, ?2, ?3, CAST(?4 AS jsonb), CAST(?5 AS jsonb), CAST(?6 AS jsonb), CAST(?7 AS jsonb))", nativeQuery = true)
    void insertYearSections(String yearSectionId, String department, int semester, String firstYearSections, String secondYearSections, String thirdYearSections, String fourthYearSections);

    @Query(value = "SELECT * FROM year_sections WHERE department = ?1 LIMIT 1", nativeQuery = true)
    YearSection getYearSections(String department);
}
