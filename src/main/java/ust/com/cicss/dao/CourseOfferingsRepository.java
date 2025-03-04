package ust.com.cicss.dao;


import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ust.com.cicss.models.Course;
import ust.com.cicss.models.CourseDTO;
import ust.com.cicss.models.CourseOfferings;

import java.util.List;

@Repository
public interface CourseOfferingsRepository extends JpaRepository<CourseOfferings, String> {

    @Query(value = "SELECT c.course_id, c.course_code, c.course_name, c.total_units, c.course_type " +
            "FROM backend.courses c " +
            "JOIN backend.course_offerings co " +
            "ON c.course_id = ANY(co.course_ids) " +
            "WHERE year = ?1 AND semester = ?2 AND department = ?3",
            nativeQuery = true)
    List<CourseDTO> getCourseOfferings(int year, int semester, String department);

    @Modifying
    @Transactional
    @Query(value = "UPDATE backend.course_offerings " +
            "SET course_ids = ARRAY_APPEND(course_ids, ?5) " +
            "WHERE year = ?1 AND semester = ?2 AND department = ?3 AND year_level = ?4", nativeQuery = true)
    void updateCourseOfferings(int year, int semester, String department, int yearLevel, String courseId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE backend.course_offerings SET department = ?2 WHERE course_offerings_id = ?1", nativeQuery = true)
    void updateDepartment(String id, String department);

    @Modifying
    @Transactional
    @Query(value = "UPDATE backend.course_offerings SET year_level = ?2 WHERE course_offerings_id = ?1", nativeQuery = true)
    void updateYearLevel(String id, int yearLevel);

    @Modifying
    @Transactional
    @Query(value = "UPDATE backend.course_offerings SET semester = ?2 WHERE course_offerings_id = ?1", nativeQuery = true)
    void updateSemester(String id, int semester);

    @Modifying
    @Transactional
    @Query(value = "UPDATE backend.course_offerings SET specialization = ?2 WHERE course_offerings_id = ?1", nativeQuery = true)
    void updateSpecialization(String id, String specialization);

    @Modifying
    @Transactional
    @Query(value = "UPDATE backend.course_offerings SET year = ?2 WHERE course_offerings_id = ?1", nativeQuery = true)
    void updateYear(String id, int year);
}
