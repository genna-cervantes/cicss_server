package com.example.cicss.dao;

import com.example.cicss.model.CourseOfferings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseOfferingsRepository extends JpaRepository<CourseOfferings, String> {
}
