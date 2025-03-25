package ust.com.cicss.models;

public class DepartmentChairDetails {
    private String name;
    private String email;

    public DepartmentChairDetails(){}

    public DepartmentChairDetails(String name, String email){
        this.email = email;
        this.name = name;
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
}
