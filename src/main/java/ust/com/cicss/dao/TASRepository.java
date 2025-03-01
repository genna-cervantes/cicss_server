
package ust.com.cicss.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ust.com.cicss.models.TAS;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface TASRepository extends JpaRepository<TAS, String> {
    @Query(
            value = "SELECT COUNT(*) > 0 FROM teaching_academic_staff WHERE email = ?1",
            nativeQuery = true
    )
    boolean authByEmail(String email);

    @Query(value = "SELECT tas_id FROM backend.teaching_academic_staff", nativeQuery = true)
    List<String> getAllTASIds();

    @Query(value = "SELECT name, units, courses, restrictions FROM teaching_academic_staff WHERE tas_id = ?", nativeQuery = true)
    Object getTASConstraintById(String TASId);

}
