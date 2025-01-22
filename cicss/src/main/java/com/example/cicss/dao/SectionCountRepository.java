package com.example.cicss.dao;

import com.example.cicss.model.SectionCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectionCountRepository extends JpaRepository<SectionCount, String> {

    @Query("select sc from SectionCount sc where sc.department=?1")
    List<SectionCount> getAllSectionCountsByDepartment(String department);
}
