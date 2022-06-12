package model;

import java.io.Serializable;

public class Salary implements Serializable {
    public static final int WORKING_HOURS_PARTTIME = 4;
    public static final int WORKING_HOURS_FULLTIME = 8;
    public static final int PAY_PER_HOUR_STAFF = 5000;
    public static final int PAY_PER_HOUR_ACCOUNTANT = 9500;
    public static final int PAY_PER_HOUR_MANAGER = 20000;
    public static final int DEFAULT_WORKING_DAYS = 22;

    private int id;
    private String name;
    private String workingType;
    private String position;
    private int workingDays;
    private int salaryPerMonth;

    public Salary() {
    }

    public Salary(int id, String name, String workingType, String position, int workingDays, int salaryPerMonth) {
        this.id = id;
        this.name = name;
        this.workingType = workingType;
        this.position = position;
        this.workingDays = workingDays;
        this.salaryPerMonth = salaryPerMonth;
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

    public int getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(int workingDays) {
        this.workingDays = workingDays;
    }

    public int getSalaryPerMonth() {
        return salaryPerMonth;
    }

    public void setSalaryPerMonth(int salaryPerMonth) {
        this.salaryPerMonth = salaryPerMonth;
    }

    @Override
    public String toString() {
        return
                " Id : " + id
                + " , Name : " + name
                + " , Working type : " + workingType
                + " , Position : " + position
                + " , Working days : " + workingDays
                + " , Salary per month : " + salaryPerMonth
                        + "\n" ;
    }
}
