
package ust.com.cicss.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import ust.com.cicss.models.Restrictions;
import ust.com.cicss.models.TAS;

@Repository
public interface TASRepository extends JpaRepository<TAS, String> {
    @Query(
            value = "SELECT COUNT(*) > 0 FROM teaching_academic_staff WHERE email = ?1",
            nativeQuery = true
    )
    boolean authByEmail(String email);

    @Query(value = "SELECT tas_id FROM teaching_academic_staff", nativeQuery = true)
    List<String> getAllTASIds();

    @Query(value = "SELECT tas_id FROM teaching_academic_staff WHERE main_department = ?", nativeQuery = true)
    List<String> getAllTASIdsByDepartment(String department);

    @Query(value = "SELECT name, units, courses, restrictions FROM teaching_academic_staff WHERE tas_id = ?", nativeQuery = true)
    Object getTASConstraintById(String TASId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE teaching_academic_staff SET name = ?2 WHERE tas_id = ?1", nativeQuery = true)
    void updateName(String tas_id, String name);

    @Modifying
    @Transactional
    @Query(value = "UPDATE teaching_academic_staff SET units = ?2 WHERE tas_id = ?1", nativeQuery = true)
    void updateUnits(String tas_id, int units);

    @Modifying
    @Transactional
    @Query(value = "UPDATE teaching_academic_staff SET email = ?2 WHERE tas_id = ?1", nativeQuery = true)
    void updateEmail(String tas_id, String email);

    @Modifying
    @Transactional
    @Query(value = "UPDATE teaching_academic_staff SET courses = ?2 WHERE tas_id = ?1", nativeQuery = true)
    void updateCourses(String tas_id, String[] courses);

    @Modifying
    @Transactional
    @Query(value = "UPDATE teaching_academic_staff SET restrictions = ?2 WHERE tas_id = ?1", nativeQuery = true)
    void updateRestrictions(String tas_id, Restrictions restrictions);

}
