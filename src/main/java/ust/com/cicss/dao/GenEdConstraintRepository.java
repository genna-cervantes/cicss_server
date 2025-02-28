package ust.com.cicss.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ust.com.cicss.models.GenEdConstraint;

@Repository
public interface GenEdConstraintRepository extends JpaRepository<GenEdConstraint, String> {
}
