package ust.com.cicss.models;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.*;

@Entity
public class DepartmentChair {
    @Id
    private String departmentChairId;
    private String department;
    private String departmentChairName;
    private String departmentChairEmail;
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public DepartmentChair()
    {

    }

    public DepartmentChair(String departmentChairId, String department, String departmentChairName, String departmentChairEmail, Date createAt, Date updatedAt) {
        this.departmentChairId = departmentChairId;
        this.department = department;
        this.departmentChairName = departmentChairName;
        this.departmentChairEmail = departmentChairEmail;
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

    public String getDepartmentChairId() {
        return departmentChairId;
    }

    public void setDepartmentChairId(String departmentChairId) {
        this.departmentChairId = departmentChairId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartmentChairName() {
        return departmentChairName;
    }

    public void setDepartmentChairName(String departmentChairName) {
        this.departmentChairName = departmentChairName;
    }

    public String getDepartmentChairEmail() {
        return departmentChairEmail;
    }

    public void setDepartmentChairEmail(String departmentChairEmail) {
        this.departmentChairEmail = departmentChairEmail;
    }

}
