package com.example.cicss.dao;

import com.example.cicss.model.DepartmentChair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentChairRepository extends JpaRepository<DepartmentChair, String> {
}
