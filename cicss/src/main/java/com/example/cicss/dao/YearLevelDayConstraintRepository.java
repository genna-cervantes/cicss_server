package com.example.cicss.dao;

import com.example.cicss.model.YearLevelDayConstraint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YearLevelDayConstraintRepository extends JpaRepository<YearLevelDayConstraint, String> {
}
