package ust.com.cicss.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ust.com.cicss.models.TASConstraint;

@Repository
public interface TASConstraintRepository extends JpaRepository<TASConstraint, String> {
}
