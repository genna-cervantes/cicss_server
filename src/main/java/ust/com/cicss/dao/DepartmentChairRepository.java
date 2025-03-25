package ust.com.cicss.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ust.com.cicss.models.DepartmentChair;
import ust.com.cicss.models.DepartmentChairDetails;

@Repository
public interface DepartmentChairRepository extends JpaRepository<DepartmentChair, String> {

    @Query(
            value = "SELECT email, department_chair_name AS name FROM department_chair WHERE email = ?1",
            nativeQuery = true
    )
    DepartmentChairDetails getDepartmentChairByEmail(String email);
}
