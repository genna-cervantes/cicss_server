package ust.com.cicss.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ust.com.cicss.models.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {
}
