package ust.com.cicss.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class DepartmentChair {
    @Id
    private String departmentChairId;
    private String department;
    private String departmentChairName;
    private String departmentChairEmail;
    private Date createAt;
    private Date updatedAt;

    public DepartmentChair()
    {

    }

    public DepartmentChair(String departmentChairId, String department, String departmentChairName, String departmentChairEmail, Date createAt, Date updatedAt) {
        this.departmentChairId = departmentChairId;
        this.department = department;
        this.departmentChairName = departmentChairName;
        this.departmentChairEmail = departmentChairEmail;
        this.createAt = createAt;
        this.updatedAt = updatedAt;
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

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
