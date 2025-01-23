package ust.com.cicss.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ust.com.cicss.models.DepartmentChair;

@Repository
public interface TASRepository extends JpaRepository<TAS, String> {
    @Query(
        value = "SELECT COUNT(*) > 0 FROM department_chair WHERE email = ?1",
        nativeQuery = true
    )
    boolean authByEmail(String email);
}
