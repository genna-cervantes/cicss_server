package ust.com.cicss.dao;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ust.com.cicss.models.Course;
import ust.com.cicss.models.GenEdConstraint;
import ust.com.cicss.models.Restrictions;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {

    @Query(value = "SELECT course_id, course_name, course_code, restrictions FROM backend.courses WHERE course_category = 'gened';", nativeQuery = true)
    List<Course> getAllGenEdCourses();

    @Modifying
    @Transactional
    @Query(value = "UPDATE backend.courses SET restrictions = ?1 WHERE course_code = ?2", nativeQuery = true)
    void updateGenEdConstraint(Restrictions restrictions, String course_code);

    @Query(value = "UPDATE backend.courses SET restrictions = CAST(?1 AS jsonb) WHERE course_code = ?2", nativeQuery = true)
    void updateGenEdConstraint(String restrictions, String course_code);
}

