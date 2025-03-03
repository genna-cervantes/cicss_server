package ust.com.cicss.dao;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ust.com.cicss.models.Restrictions;
import ust.com.cicss.models.YearLevelTimeConstraint;
import org.springframework.stereotype.Repository;
import ust.com.cicss.models.YearLevelTimeConstraintDTO;

import java.util.List;

@Repository
public interface YearLevelTimeConstraintRepository extends JpaRepository<YearLevelTimeConstraint, String> {

    @Query(value = "SELECT * FROM backend.year_level_time_constraints WHERE department = ?1 AND year_level = ?2", nativeQuery = true)
    YearLevelTimeConstraint getYLTC(String department, int year_level);

    @Modifying
    @Transactional
    @Query(value = "UPDATE backend.year_level_time_constraints SET restrictions = ?2 WHERE year_level_time_constraint_id = ?1", nativeQuery = true)
    void updateRestrictions(String id, Restrictions restrictions);

    @Modifying
    @Transactional
    @Query(value = "UPDATE backend.year_level_time_constraints SET year_level = ?2 WHERE year_level_time_constraint_id = ?1", nativeQuery = true)
    void updateYearLevel(String id, int yearLevel);

    @Modifying
    @Transactional
    @Query(value = "UPDATE backend.year_level_time_constraints SET department = ?2 WHERE year_level_time_constraint_id = ?1", nativeQuery = true)
    void updateDepartment(String id, String department);
}
