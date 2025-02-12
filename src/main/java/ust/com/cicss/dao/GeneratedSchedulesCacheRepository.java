package ust.com.cicss.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ust.com.cicss.models.GeneratedSchedulesCache;

import java.util.Map;

@Repository
public interface GeneratedSchedulesCacheRepository extends JpaRepository<GeneratedSchedulesCache, String> {

    @Query(value = "SELECT schedule FROM backend.generated_schedules_cache ORDER BY schedule_cache_id ASC LIMIT 1", nativeQuery = true)
    String getCachedSchedule();
}
