package ust.com.cicss.models;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;


@Entity
@Table(name = "year_sections")
public class YearSection {
    @Id
    @Column(name = "year_section_id")
    private String yearSectionId;
    @Column(name = "department")
    private String department;
    @Column(name = "year_level")
    private int yearLevel;
    @Column(name = "semester")
    private int semester;
    @Column(name = "sections")
    @JdbcTypeCode(SqlTypes.JSON)
    private ArrayList<Section> sections;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public YearSection() {
    }

    public YearSection(String yearSectionId, String department, int yearLevel, int semester, ArrayList<Section> sections) {
        this.yearSectionId = yearSectionId; 
        this.department = department;
        this.yearLevel = yearLevel;
        this.semester = semester;
        this.sections = sections;
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

    public void setId(String yearSectionId){
        this.yearSectionId = yearSectionId;
    }

    public void setDepartment(String department){
        this.department = department;   
    }

    public void setYearLevel(int yearLevel){
        this.yearLevel = yearLevel;
    }

    public void setSemester(int semester){
        this.semester = semester;
    }

    public void setSections(ArrayList<Section> sections){
        this.sections = sections;
    }

    public String getId(){
        return yearSectionId;
    }

    public String getDepartment(){
        return department; 
    }

    public int getYearLevel() {
        return yearLevel;
    }

    public int getSemester(){
        return semester;
    }

    public ArrayList<Section> getSections(){
        return sections;
    }

   
}
