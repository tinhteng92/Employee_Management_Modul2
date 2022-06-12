package service;

import io.ReaderAndWriter;
import model.Salary;

import java.util.List;

public class SalaryCalculation {
    public final static String PATH_BASE_SALARY = ReaderAndWriter.PATH + "baseSalary.txt";
    public final static String PATH_ACTUAL_SALARY = ReaderAndWriter.PATH + "actualSalary1.txt";
    public static List<Salary> baseSalaryList = new ReaderAndWriter<Salary>().readFromFile(PATH_BASE_SALARY);
    public static List<Salary> actualSalaryList = new ReaderAndWriter<Salary>().readFromFile(PATH_ACTUAL_SALARY);


    public List<Salary> writeBaseSalaryToFile(){
        new ReaderAndWriter<Salary>().writeToFile(PATH_BASE_SALARY, baseSalaryList);
        return baseSalaryList;
    }
    public void saveBaseSalaryToList(Salary salary){
        baseSalaryList.add(salary);
    }
    public void creatBaseSalary(Salary salary){
        saveBaseSalaryToList(salary);
        writeBaseSalaryToFile();
    }

    public List<Salary> showBasePayroll(){
        return writeBaseSalaryToFile();
    }

    public static int calculateBaseSalary(String position, String workingType){
        int baseSalary = 0;
        if(position.equalsIgnoreCase("staff")) {
            if (workingType.equalsIgnoreCase("partTime")) {
                baseSalary = Salary.WORKING_HOURS_PARTTIME * Salary.PAY_PER_HOUR_STAFF * Salary.DEFAULT_WORKING_DAYS;
            } else {
                baseSalary = Salary.WORKING_HOURS_FULLTIME * Salary.PAY_PER_HOUR_STAFF * Salary.DEFAULT_WORKING_DAYS;
            }
        }else if (position.equalsIgnoreCase("Manager")){
            baseSalary = Salary.WORKING_HOURS_FULLTIME * Salary.PAY_PER_HOUR_MANAGER * Salary.DEFAULT_WORKING_DAYS;
        }else {
            baseSalary = Salary.WORKING_HOURS_FULLTIME * Salary.PAY_PER_HOUR_ACCOUNTANT * Salary.DEFAULT_WORKING_DAYS;
        }
        return baseSalary;
    }




    public List<Salary> writeActualSalaryToFile(){
        new ReaderAndWriter<Salary>().writeToFile(PATH_ACTUAL_SALARY, actualSalaryList);
        return actualSalaryList;
    }

    public void saveActualSalaryToList(Salary salary){
        actualSalaryList.add(salary);
    }
    public void creatActualSalary(Salary salary){
        saveActualSalaryToList(salary);
        writeActualSalaryToFile();
    }
    public List<Salary> showActualPayroll(){
        return writeActualSalaryToFile();
    }
    public static int calculateActualSalary(String position, String workingType, int workingDays){
        int actualSalary = 0;
        if(position.equalsIgnoreCase("staff")) {
            if (workingType.equalsIgnoreCase("partTime")) {
                actualSalary = Salary.WORKING_HOURS_PARTTIME * Salary.PAY_PER_HOUR_STAFF * workingDays;
            } else {
                actualSalary = Salary.WORKING_HOURS_FULLTIME * Salary.PAY_PER_HOUR_STAFF * workingDays;
            }
        }else if (position.equalsIgnoreCase("Manager")){
            actualSalary = Salary.WORKING_HOURS_FULLTIME * Salary.PAY_PER_HOUR_MANAGER * workingDays;
        }else {
            actualSalary = Salary.WORKING_HOURS_FULLTIME * Salary.PAY_PER_HOUR_ACCOUNTANT * workingDays;
        }
        return actualSalary;
    }

}
