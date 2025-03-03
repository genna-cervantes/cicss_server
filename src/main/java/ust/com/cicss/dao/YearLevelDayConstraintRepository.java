package ust.com.cicss.dao;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ust.com.cicss.models.YearLevelDayConstraint;
import ust.com.cicss.models.YearLevelDayConstraintDTO;

import java.util.List;


@Repository
public interface YearLevelDayConstraintRepository extends JpaRepository<YearLevelDayConstraint, String> {

    @Query(value = "SELECT year_level_day_constraint_id, available_days, max_days FROM backend.year_level_day_constraints WHERE year_level = ?2 AND department = ?1", nativeQuery = true)
    YearLevelDayConstraintDTO getYLDC(String department, int year_level);

    @Modifying
    @Transactional
    @Query(value = "UPDATE backend.year_level_day_constraints SET available_days = ?2 WHERE year_level_day_constraint_id = ?1", nativeQuery = true)
    void updateAvailableDays(String id, String[] value);

    @Modifying
    @Transactional
    @Query(value = "UPDATE backend.year_level_day_constraints SET max_days = ?2 WHERE year_level_day_constraint_id = ?1", nativeQuery = true)
    void updateMaxDays(String id, int value);

}