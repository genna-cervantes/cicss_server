package com.example.cicss.dao;

import com.example.cicss.model.TASConstraint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TASConstraintRepository extends JpaRepository<TASConstraint, String> {
}
