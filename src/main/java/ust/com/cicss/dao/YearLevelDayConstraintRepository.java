package ust.com.cicss.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ust.com.cicss.models.YearLevelDayConstraint;

@Repository
public interface YearLevelDayConstraintRepository extends JpaRepository<YearLevelDayConstraint, String> {
}
