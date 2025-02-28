package ust.com.cicss.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ust.com.cicss.models.CourseOfferings;

@Repository
public interface CourseOfferingsRepository extends JpaRepository<CourseOfferings, String> {
}
