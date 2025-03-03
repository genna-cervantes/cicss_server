

package ust.com.cicss.models;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.Map;

@Entity
@Table(name = "teaching_academic_staff")
public class TAS {

    @Id
    @Column(name = "tas_id")
    private String tasId;

    @Column(name = "units")
    @Min(value = 15,message = "units field is incorrect")
    private int units;

    @Column(name = "courses")
    @Size(min = 1)
    private String[] courses;

    @Column(name = "name")
    @NotNull(message = "The name field is null")
    @NotBlank(message = "the name field is empty")
    private String name;

    @Column(name = "email")
    @NotNull(message = "The email field is null")
    @NotBlank(message = "the email field is empty")
    private String email;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "restrictions")
    @NotNull(message = "The restrictions field is null")
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

    public String getTasId() {
        return tasId;
    }

    public void setTasId(String tasId) {
        this.tasId = tasId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setRestrictions(Restrictions restrictions) {
        this.restrictions = restrictions;
    }
}
