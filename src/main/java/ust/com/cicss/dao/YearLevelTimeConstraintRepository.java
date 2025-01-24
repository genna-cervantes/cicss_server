package ust.com.cicss.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ust.com.cicss.models.YearLevelTimeConstraint;
import org.springframework.stereotype.Repository;

@Repository
public interface YearLevelTimeConstraintRepository extends JpaRepository<YearLevelTimeConstraint, String> {
}
