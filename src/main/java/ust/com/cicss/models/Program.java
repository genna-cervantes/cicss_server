package ust.com.cicss.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "programs")
public class Program {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "program_name", nullable = false)
    private String programName;

    @Column(name = "no_years", nullable = false)
    private int noYears;

    @Column(name = "dc_email", nullable = false)
    private String dcEmail;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public int getNoYears() {
        return noYears;
    }

    public void setNoYears(int noYears) {
        this.noYears = noYears;
    }

    public String getDcEmail() {
        return dcEmail;
    }

    public void setDcEmail(String dcEmail) {
        this.dcEmail = dcEmail;
    }
}