package controller;

import io.ReaderAndWriter;
import model.Salary;

import java.util.List;

public class SalaryCaculation {
    public final static String PATH_SALARY = ReaderAndWriter.PATH + "salary.txt";
    public static List<Salary> salaryList = new ReaderAndWriter<Salary>().readFromFile(PATH_SALARY);

    public List<Salary> writeSlaryToFile(){
        new ReaderAndWriter<Salary>().writeToFile(PATH_SALARY, salaryList);
        return salaryList;
    }
    public void saveToList(Salary salary){
        salaryList.add(salary);
    }
    public static int calculateSalary(String position, String workingType){
        int baseSalary = 0;
        if(position.equalsIgnoreCase("staff")) {
            if (workingType.equalsIgnoreCase("partime")) {
                baseSalary = Salary.WORKING_HOURS_PARTTIME * Salary.PAY_PER_HOUR_STAFF * Salary.DEFAULT_WORKING_DAYS;
            } else {
                baseSalary = Salary.WORKING_HOURS_FULLTIME * Salary.PAY_PER_HOUR_STAFF * Salary.DEFAULT_WORKING_DAYS;
            }
        }else if (position.equalsIgnoreCase("Manager")){
            baseSalary = Salary.WORKING_HOURS_FULLTIME * Salary.PAY_PER_HOUR_MANAGER * Salary.DEFAULT_WORKING_DAYS;
        }
        return baseSalary;
    }

    public void creatSalary(Salary salary){
        saveToList(salary);
        writeSlaryToFile();
    }
    public List<Salary> showPayroll(){
        return writeSlaryToFile();
    }
}
