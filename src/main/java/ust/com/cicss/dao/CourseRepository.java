package ust.com.cicss.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import ust.com.cicss.models.Course;
import ust.com.cicss.models.GenEdConstraint;
import ust.com.cicss.models.Restrictions;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {

    @Query(value = "SELECT name AS courseName, subject_code AS courseCode, restrictions::json AS restrictions FROM courses WHERE category = 'gened';", nativeQuery = true)
    List<GenEdConstraint> getAllGenEdCourseConstraints();

    @Query(value = "SELECT course_id FROM courses WHERE category = 'gened';", nativeQuery = true)
    List<String> getAllGendCourseIds();

    @Modifying
    @Transactional
    @Query(value = "UPDATE courses SET restrictions = CAST(?1 AS jsonb) WHERE subject_code = ?2", nativeQuery = true)
    void updateGenEdConstraint(Restrictions restrictions, String course_code);

    @Modifying
    @Transactional
    @Query(value = "UPDATE courses SET is_active = FALSE WHERE subject_code = ?1", nativeQuery = true)
    void deleteCourseFromCourseCode(String courseCode);


}

