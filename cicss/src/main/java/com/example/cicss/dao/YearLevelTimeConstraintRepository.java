package com.example.cicss.dao;

import com.example.cicss.model.YearLevelTimeConstraint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YearLevelTimeConstraintRepository extends JpaRepository<YearLevelTimeConstraint, String> {
}
