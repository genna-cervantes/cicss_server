package ust.com.cicss.dao;

import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ust.com.cicss.models.schedule.Schedule;
import ust.com.cicss.models.schedule.SectionSchedule;

import java.util.Map;

@Repository
@Table(name = "schedules")
public interface ScheduleRepository extends JpaRepository<Schedule, String> {

//    @Query(value = "select s.schedule from schedules s where s.schedule_id=?", nativeQuery = true)
//    Map<String, SectionSchedule> getSchedule(String scheduleId);

//    @Query(value = "", nativeQuery = true)
//    void updateCSReady(boolean csReady);
}
