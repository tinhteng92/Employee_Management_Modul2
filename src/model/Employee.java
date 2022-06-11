package model;

import java.io.Serializable;

public class Employee implements Serializable {
    private int id;
    private String name;
    private int age;
    private String gender;
    private boolean status;
    private String workingType;
    private String position;


    public Employee() {
    }

    public Employee(int id, String name, int age, String gender, boolean status, String workingType, String position) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.status = status;
        this.workingType = workingType;
        this.position = position;
    }

    public Employee(String name, boolean status) {
        this.name = name;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getWorkingType() {
        return workingType;
    }

    public void setWorkingType(String workingType) {
        this.workingType = workingType;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }


    @Override
    public String toString() {
        if (isStatus()) {
            return  " , id : "+ id
                    +" , Name : "+ name
                    +" , Age : "+ age
                    +" , Gender : "+ gender
                    +" , Status : Working"
                    +" , Working Type : "+ workingType
                    +" , Position : "+ position;


        } else {
            return " , id : "+ id
                    +" , Name : "+ name
                    +" , Age : "+ age
                    +" , Gender : "+ gender
                    +" , Status : Retired"
                    +" , Working Type : "+ workingType
                    +" , Position : "+ position;
        }
    }

    public String toStringStatus() {
        if (isStatus()){
            return " , Name : "+ name
                    +" , Position : "+ position
                    +" , Status : Working";
//
        }else {
            return " , Name : "+ name
                    +" , Position : "+ position
                    +" , Status : Retired";
        }

    }
}
