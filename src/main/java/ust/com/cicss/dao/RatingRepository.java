package ust.com.cicss.dao;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ust.com.cicss.models.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, String> {

    @Query(
            value = "SELECT rater_section, COUNT(rating) AS numberOfRatings, AVG(rating) AS averageRating, COUNT(CASE WHEN rating = 5 THEN 1 END) AS count5, COUNT(CASE WHEN rating = 4 THEN 1 END) AS count4, COUNT(CASE WHEN rating = 3 THEN 1 END) AS count3, COUNT(CASE WHEN rating = 2 THEN 1 END) AS count2, COUNT(CASE WHEN rating = 1 THEN 1 END) AS count1 FROM ratings WHERE rater_section = ?1 GROUP BY rater_section;" ,
            nativeQuery = true
    )
    Map<String, String> getSectionRating(String section);

    @Query(
            value = "SELECT r.rater_name, COUNT(r.rating) AS numberOfRatings, AVG(r.rating) AS averageRating, COUNT(CASE WHEN r.rating = 5 THEN 1 END) AS count5, COUNT(CASE WHEN r.rating = 4 THEN 1 END) AS count4, COUNT(CASE WHEN r.rating = 3 THEN 1 END) AS count3, COUNT(CASE WHEN r.rating = 2 THEN 1 END) AS count2, COUNT(CASE WHEN r.rating = 1 THEN 1 END) AS count1 FROM ratings r JOIN teaching_academic_staff tas ON r.rater_name = tas.email WHERE r.rater_name = (SELECT email FROM teaching_academic_staff WHERE tas_id = ?1) GROUP BY r.rater_name" ,
            nativeQuery = true
    )
    Map<String, String> getTASRating(String id);
    
}
