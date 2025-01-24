package com.example.cicss.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "department_chair")
public class DepartmentChair {
    @Id
    @Column(name = "department_chair_id")
    private String departmentChairId;
    @Column(name = "department")
    private String department;
    @Column(name = "department_chair_name")
    private String departmentChairName;
    @Column(name = "department_chair_email")
    private String departmentChairEmail;

    public DepartmentChair()
    {

    }

    public DepartmentChair(String departmentChairId, String department, String departmentChairName, String departmentChairEmail) {
        this.departmentChairId = departmentChairId;
        this.department = department;
        this.departmentChairName = departmentChairName;
        this.departmentChairEmail = departmentChairEmail;
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
