package ust.com.cicss.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import ust.com.cicss.models.YearLevelDayConstraint;
import ust.com.cicss.models.YearLevelDayConstraintDTO;


@Repository
public interface YearLevelDayConstraintRepository extends JpaRepository<YearLevelDayConstraint, String> {

    @Query(value = "SELECT year_day_restrictions_id AS year_level_day_constraint_id, available_days, max_days FROM year_day_restrictions WHERE year = ?2 AND department = ?1", nativeQuery = true)
    YearLevelDayConstraintDTO getYLDC(String department, int year_level);

    @Modifying
    @Transactional
    @Query(value = "UPDATE year_day_restrictions SET available_days = ?3 WHERE department = ?1 AND year = ?2", nativeQuery = true)
    void updateAvailableDays(String department, double year_level, String[] value);

    @Modifying
    @Transactional
    @Query(value = "UPDATE year_day_restrictions SET max_days = ?3 WHERE department = ?1 AND year = ?2", nativeQuery = true)
    void updateMaxDays(String department, double year_level, int value);

    @Modifying
    @Transactional
    @Query(value = "UPDATE year_day_restrictions SET is_active = 0 WHERE year_day_restrictions_id = ?1", nativeQuery = true)
    void setInactive(String id);
}



