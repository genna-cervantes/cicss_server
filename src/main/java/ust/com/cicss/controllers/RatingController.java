package ust.com.cicss.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ust.com.cicss.dao.RatingRepository;
import ust.com.cicss.models.Rating;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingRepository repo;

    @PostMapping
    public void addRating(@RequestBody Rating rating)
    {
        repo.save(rating);
    }

    @PutMapping("/{rating_id}")
    public void updateRating(@RequestBody Rating rating, @PathVariable String rating_id) {
        rating.setRatingId(rating_id);
        repo.save(rating);
    }
}
