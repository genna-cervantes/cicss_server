package ust.com.cicss.dao;

import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ust.com.cicss.models.Schedule;

@Repository
@Table(name = "schedules")
public interface ScheduleRepository extends JpaRepository<Schedule, String> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE backend.schedules SET cs_locked = ?2 WHERE schedule_id = ?1", nativeQuery = true)
    int updateCSLocked(String scheduleId, boolean csLocked);

    @Modifying
    @Transactional
    @Query(value = "UPDATE backend.schedules SET cs_ready = ?2 WHERE schedule_id = ?1", nativeQuery = true)
    int updateCSReady(String scheduleId, boolean csReady);

    @Modifying
    @Transactional
    @Query(value = "UPDATE backend.schedules SET cs_deploy = ?2 WHERE schedule_id ?1", nativeQuery = true)
    int updateCSDeploy(String scheduleId, boolean csDeploy);

    @Modifying
    @Transactional
    @Query(value = "UPDATE backend.schedules SET it_locked = ?2 WHERE schedule_id = ?1", nativeQuery = true)
    int updateITLocked(String scheduleId, boolean itlocked);

    @Modifying
    @Transactional
    @Query(value = "UPDATE backend.schedules SET it_ready = ?2 WHERE schedule_id = ?1", nativeQuery = true)
    int updateITReady(String scheduleId, boolean itReady);

    @Modifying
    @Transactional
    @Query(value = "UPDATE backend.schedules SET it_deploy = ?2 WHERE schedule_id ?1", nativeQuery = true)
    int updateITDeploy(String scheduleId, boolean itDeploy);

    @Modifying
    @Transactional
    @Query(value = "UPDATE backend.schedules SET is_locked = ?2 WHERE schedule_id = ?1", nativeQuery = true)
    int updateISLocked(String scheduleId, boolean isLocked);

    @Modifying
    @Transactional
    @Query(value = "UPDATE backend.schedules SET is_ready = ?2 WHERE schedule_id = ?1", nativeQuery = true)
    int updateISReady(String scheduleId, boolean isReady);

    @Modifying
    @Transactional
    @Query(value = "UPDATE backend.schedules SET is_deploy = ?2 WHERE schedule_id = ?1", nativeQuery = true)
    int updateISDeploy(String scheduleId, boolean isDeploy);

    @Query(value = "SELECT class_schedule from schedules", nativeQuery = true)
    String getSchedule();
}
