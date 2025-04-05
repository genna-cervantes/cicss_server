package ust.com.cicss.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import ust.com.cicss.models.Restrictions;
import ust.com.cicss.models.TAS;
import ust.com.cicss.models.TASDetails;

@Repository
public interface TASRepository extends JpaRepository<TAS, String> {
    @Query(
            value = "SELECT email, name FROM teaching_academic_staff WHERE email = ?1",
            nativeQuery = true
    )
    TASDetails getTasFromEmail(String email);

    @Query(value = "SELECT tas_id FROM teaching_academic_staff WHERE is_active = true;", nativeQuery = true)
    List<String> getAllTASIds();

    @Query(value = "SELECT tas_id FROM teaching_academic_staff WHERE main_department = ? AND is_active = true", nativeQuery = true)
    List<String> getAllTASIdsByDepartment(String department);

    @Query(value = "SELECT name, units, courses, restrictions FROM teaching_academic_staff WHERE tas_id = ? AND is_active = true ORDER BY name", nativeQuery = true)
    Object getTASConstraintById(String TASId);

    @Query(value = "SELECT name FROM teaching_academic_staff WHERE tas_id = ?1", nativeQuery = true)
    String getTASNameFromId(String TASId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE teaching_academic_staff SET name = ?2 WHERE tas_id = ?1 AND is_active = true", nativeQuery = true)
    void updateName(String tas_id, String name);

    @Modifying
    @Transactional
    @Query(value = "UPDATE teaching_academic_staff SET units = ?2 WHERE tas_id = ?1 AND is_active = true", nativeQuery = true)
    void updateUnits(String tas_id, int units);

    @Modifying
    @Transactional
    @Query(value = "UPDATE teaching_academic_staff SET email = ?2 WHERE tas_id = ?1 AND is_active = true", nativeQuery = true)
    void updateEmail(String tas_id, String email);

    @Modifying
    @Transactional
    @Query(value = "UPDATE teaching_academic_staff SET courses = ?2 WHERE tas_id = ?1 AND is_active = true", nativeQuery = true)
    void updateCourses(String tas_id, String[] courses);

    @Modifying
    @Transactional
    @Query(value = "UPDATE teaching_academic_staff SET restrictions = ?2 WHERE tas_id = ?1 AND is_active = true", nativeQuery = true)
    void updateRestrictions(String tas_id, Restrictions restrictions);

    @Modifying
    @Transactional
    @Query(value = "UPDATE teaching_academic_staff SET is_active = ?2 WHERE tas_id = ?1", nativeQuery = true)
    void updateIsActive(String tas_id, boolean is_active);

    @Query(value = "DELETE FROM teaching_academic_staff WHERE tas_id = ?1", nativeQuery = true)
    void deleteTAS(String tas_id);
}
