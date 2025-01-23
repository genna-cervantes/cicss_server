package ust.com.cicss.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ust.com.cicss.models.TAS;

@Repository
public interface TASRepository extends JpaRepository<TAS, String> {
    @Query(
        value = "SELECT COUNT(*) > 0 FROM teaching_academic_staff WHERE email = ?1",
        nativeQuery = true
    )
    boolean authByEmail(String email);
}
