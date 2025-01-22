package com.example.cicss.dao;

import com.example.cicss.model.GenEdConstraint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenEdConstraintRepository extends JpaRepository<GenEdConstraint, String> {
}
