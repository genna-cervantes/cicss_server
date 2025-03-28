package ust.com.cicss.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import ust.com.cicss.models.Restrictions;
import ust.com.cicss.models.YearLevelTimeConstraint;

@Repository
public interface YearLevelTimeConstraintRepository extends JpaRepository<YearLevelTimeConstraint, String> {

    @Query(value = "SELECT *, year_time_restrictions_id AS yearLevel_time_constraint_id, year AS yearLevel FROM year_time_restrictions WHERE department = ?1 AND year = ?2", nativeQuery = true)
    YearLevelTimeConstraint getYLTC(String department, int year_level);

    @Modifying
    @Transactional
    @Query(value = "UPDATE year_time_restrictions SET restrictions = ?3 WHERE department = ?1 AND year = ?2", nativeQuery = true)
    void updateRestrictions(String department, double year_level, Restrictions restrictions);

    @Modifying
    @Transactional
    @Query(value = "UPDATE year_time_restrictions SET year_level = ?2 WHERE year_time_restrictions_id = ?1", nativeQuery = true)
    void updateYearLevel(String id, int yearLevel);

    @Modifying
    @Transactional
    @Query(value = "UPDATE year_time_restrictions SET department = ?2 WHERE year_time_restrictions_id = ?1", nativeQuery = true)
    void updateDepartment(String id, String department);

    
}
