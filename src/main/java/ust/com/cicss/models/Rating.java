package ust.com.cicss.models;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "ratings")
public class Rating {

    @Id
    @Column(name = "rating_id")
    private String ratingId;

    @Column(name = "rating")
    private int rating;

    @Column(name = "rater_name")
    private String raterName;

    @Column(name = "rater_section")
    private String raterSection;

    @Column(name = "rater_type")
    private String raterType;
    
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Rating() {
        this.ratingId = UUID.randomUUID().toString().replace("-", "").substring(0, 10);
    }

    public Rating(String ratingId, int rating, String raterName, String raterSection, String raterType) {
        this.ratingId = ratingId;
        this.rating = rating;
        this.raterName = raterName;
        this.raterSection = raterSection;
        this.raterType = raterType;
    }

    @PrePersist
    protected void onCreate()
    {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate()
    {
        this.updatedAt = LocalDateTime.now();
    }

    public String getRatingId() {
        return ratingId;
    }

    public void setRatingId(String ratingId) {
        this.ratingId = ratingId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getRaterName() {
        return raterName;
    }

    public void setRaterName(String raterName) {
        this.raterName = raterName;
    }

    public String getRaterSection() {
        return raterSection;
    }

    public void setRaterSection(String raterSection) {
        this.raterSection = raterSection;
    }

    public String getRaterType() {
        return raterType;
    }

    public void setRaterType(String raterType) {
        this.raterType = raterType;
    }
}
