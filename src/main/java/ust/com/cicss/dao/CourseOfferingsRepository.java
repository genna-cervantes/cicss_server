package ust.com.cicss.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import ust.com.cicss.models.CourseDTO;
import ust.com.cicss.models.CourseOfferings;

@Repository
public interface CourseOfferingsRepository extends JpaRepository<CourseOfferings, String> {

    @Query(value = "SELECT c.course_id::TEXT AS courseId, "
            + "c.subject_code AS courseCode, "
            + "c.name AS courseName, "
            + "c.total_units::INT AS totalUnits, "
            + "c.type AS courseType, "
            + "c.category AS courseCategory "
            + "FROM courses c "
            + "JOIN curriculum co "
            + "ON c.subject_code = ANY(co.courses) "
            + "WHERE co.year = CAST(?1 AS INTEGER) "
            + "AND co.semester = CAST(?2 AS INTEGER) "
            + "AND co.department = ?3",
            nativeQuery = true)
    List<CourseDTO> getCourseOfferings(int year, int semester, String department);

    @Modifying
    @Transactional
    @Query(value = "UPDATE curriculum SET courses = ARRAY_APPEND(courses, ?4) WHERE year = ?1 AND semester = ?2 AND department = ?3", nativeQuery = true)
    void updateCourseOfferings(int year, int semester, String department, String courseCode);

    @Modifying
    @Transactional
    @Query(value = "UPDATE course_offerings SET department = ?2 WHERE course_offerings_id = ?1", nativeQuery = true)
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

    @Modifying
    @Transactional
    @Query(value = "UPDATE courses SET name = ?2 WHERE course_id = ?1;", nativeQuery = true)
    void updateName(String id, String name);

    @Modifying
    @Transactional
    @Query(value = "UPDATE courses SET subject_code = ?2 WHERE course_id = ?1;", nativeQuery = true)
    void updateCourseCodeCoursesTable(String id, String courseCode);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE curriculum SET courses = array_replace(courses, ?4, ?5) WHERE department = ?1 AND year = ?2 AND semester = ?3;", nativeQuery = true)
    void updateCourseCodeCurriculumTable(String department, double year, double semester, String prevCourseCode, String newCourseCode);

    @Modifying
    @Transactional
    @Query(value = "UPDATE courses SET total_units = ?2 WHERE course_id = ?1;", nativeQuery = true)
    void updateTotalUnits(String id, double totalUnits);

    @Modifying
    @Transactional
    @Query(value = "UPDATE courses SET type = ?2 WHERE course_id = ?1;", nativeQuery = true)
    void updateCourseType(String id, String type);

    @Modifying
    @Transactional
    @Query(value = "UPDATE courses SET category = ?2 WHERE course_id = ?1;", nativeQuery = true)
    void updateCourseCategory(String id, String category);

}
