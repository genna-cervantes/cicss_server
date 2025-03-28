package ust.com.cicss.models;

public class TASDetails {
    private String name;
    private String email;
    private String department;

    public TASDetails(){}

    public TASDetails(String name, String email, String department){
        this.name = name;
        this.email = email;
        this.department = department;
    }

    public String getName(){
        return this.name;
    }

    public String getEmail(){
        return this.email;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getDepartment(){
        return this.department;
    }

    public void setDepartment(String department){
        this.department = department;
    }
}
