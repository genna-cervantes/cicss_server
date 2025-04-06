package ust.com.cicss.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ust.com.cicss.dao.RatingRepository;
import ust.com.cicss.models.Rating;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingRepository repo;

    @GetMapping
    public String test() {
        return "hello world";
    }

    @PreAuthorize("hasAuthority('ROLE_Department_Chair') or hasAuthority('ROLE_Student') or hasAuthority('ROLE_TAS')")
    @PostMapping
    public void addRating(@RequestBody Rating rating) {
        repo.save(rating);
    }

    @PreAuthorize("hasAuthority('ROLE_Department_Chair') or hasAuthority('ROLE_Student') or hasAuthority('ROLE_TAS')")
    @GetMapping("/section/{section}")
    public ResponseEntity<?> getRatingPerSection(@PathVariable String section) {
        Map<String, String> ratingData = repo.getSectionRating(section);

        Map<String, Object> response = new HashMap<>();
        response.put("averageRating", ratingData.get("averageRating"));
        response.put("numberOfRatings", ratingData.get("numberOfRatings"));
        response.put("count1", ratingData.get("count1"));
        response.put("count2", ratingData.get("count2"));
        response.put("count3", ratingData.get("count3"));
        response.put("count4", ratingData.get("count4"));
        response.put("count5", ratingData.get("count5"));

        return ResponseEntity.ok(response);
    }

    @PreAuthorize("hasAuthority('ROLE_Department_Chair') or hasAuthority('ROLE_Student') or hasAuthority('ROLE_TAS')")
    @GetMapping("/tas/{id}")
    public ResponseEntity<?> getRatingPerTAS(@PathVariable String id) {
        Map<String, String> ratingData = repo.getTASRating(id);

        Map<String, Object> response = new HashMap<>();
        response.put("averageRating", ratingData.get("averageRating"));
        response.put("numberOfRatings", ratingData.get("numberOfRatings"));
        response.put("count1", ratingData.get("count1"));
        response.put("count2", ratingData.get("count2"));
        response.put("count3", ratingData.get("count3"));
        response.put("count4", ratingData.get("count4"));
        response.put("count5", ratingData.get("count5"));

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{rating_id}")
    public void updateRating(@RequestBody Rating rating, @PathVariable String rating_id) {
        rating.setRatingId(rating_id);
        repo.save(rating);
    }
}
