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
    @Column(name = "semester")
    private int semester;
    @Column(name = "first_year_sections")
    @JdbcTypeCode(SqlTypes.JSON)
    private ArrayList<Section> firstYearSections;
    @Column(name = "second_year_sections")
    @JdbcTypeCode(SqlTypes.JSON)
    private ArrayList<Section> secondYearSections;
    @Column(name = "third_year_sections")
    @JdbcTypeCode(SqlTypes.JSON)
    private ArrayList<Section> thirdYearSections;
    @Column(name = "fourth_year_sections")
    @JdbcTypeCode(SqlTypes.JSON)
    private ArrayList<Section> fourthYearSections;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public YearSection() {
    }

    public YearSection(String yearSectionId, String department, int semester, ArrayList<Section> firstYearSections, ArrayList<Section> secondYearSections, ArrayList<Section> thirdYearSections, ArrayList<Section> fourthYearSections) {
        this.yearSectionId = yearSectionId; 
        this.department = department;
        this.semester = semester;
        this.firstYearSections = firstYearSections;
        this.secondYearSections = secondYearSections;
        this.thirdYearSections = thirdYearSections;
        this.fourthYearSections = fourthYearSections;
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

    public void setSemester(int semester){
        this.semester = semester;
    }

    public void setFirstYearSections(ArrayList<Section> sections){
        this.firstYearSections = sections;
    }
    public void setSecondYearSections(ArrayList<Section> sections){
        this.secondYearSections = sections;
    }
    public void setThirdYearSections(ArrayList<Section> sections){
        this.thirdYearSections = sections;
    }
    public void setFourthYearSections(ArrayList<Section> sections){
        this.fourthYearSections = sections;
    }

    public String getId(){
        return yearSectionId;
    }

    public String getDepartment(){
        return department; 
    }

    public int getSemester(){
        return semester;
    }

    public ArrayList<Section> getFirstYearSections(){
        return firstYearSections;
    }
    public ArrayList<Section> getSecondYearSections(){
        return secondYearSections;
    }
    public ArrayList<Section> getThirdYearSections(){
        return thirdYearSections;
    }
    public ArrayList<Section> getFourthYearSections(){
        return fourthYearSections;
    }

   
}
