package ust.com.cicss.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ust.com.cicss.models.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, String> {
}
