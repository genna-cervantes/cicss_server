package ust.com.cicss.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "teaching_academic_staff")
public class TAS {
    
    @Id
    @Column(name = "tas_id")
    private String tasId;

    @Column(name = "units")
    private int units;

    @Column(name = "courses")
    private String[] courses;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Embedded
    @Column(name = "restriction")
    private Restrictions restrictions;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


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

    // setter and getter

    public void setId(String id){
        this.tasId = id;
    }

    public void setUnits(int units){
        this.units = units;
    }

    public void setCourses(String[] courses){
        this.courses = courses;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setRestriction(Restrictions restrictions){
        this.restrictions = restrictions;
    }

    public String getId(){
        return this.tasId;
    }

    public int getUnits(){
        return this.units;
    }

    public String[] getCourses(){
        return this.courses;
    }

    public Restrictions getRestrictions(){
        return this.restrictions;
    }


}
