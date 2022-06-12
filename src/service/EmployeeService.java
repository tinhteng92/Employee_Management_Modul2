package service;
import io.ReaderAndWriter;
import model.Employee;
import model.Salary;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static service.SalaryCalculation.*;

public class EmployeeService {
    public final static String PATH_EMPLOYEE = ReaderAndWriter.PATH + "employee.txt";
    public static List<Employee> employeeList = new ReaderAndWriter<Employee>().readFromFile(PATH_EMPLOYEE);


    public List<Employee> writeEmpToFile() {
        new ReaderAndWriter<Employee>().writeToFile(PATH_EMPLOYEE, employeeList);
        return employeeList;
    }

    public void saveToList(Employee employee) {
        employeeList.add(employee);
    }

    public void deleteById(int id) {
        boolean check = false;
        for (int i = 0; i < employeeList.size(); i++) {
            if (id == employeeList.get(i).getId()) {
                employeeList.remove(i);
                baseSalaryList.remove(i);
                new ReaderAndWriter<Employee>().writeToFile(PATH_EMPLOYEE, employeeList);
                System.out.println("Delete successful");
                check = true;
                break;
            }
        }
        if (!check) {
            System.out.println("Not found!");
        }
    }

    public void checkStatusByName(String name) {
        List<Employee> resultList = new ArrayList<>();
        boolean check = false;
        for (Employee emp: employeeList) {
            if (emp.getName().toLowerCase(Locale.ROOT).contains(name.toLowerCase(Locale.ROOT))) {
                resultList.add(emp);
                check = true;
            }
        }
        if (!check) {
            System.out.println("Not found");
        }
        for (Employee emp : resultList) {
            System.out.println(emp.toStringStatus());
        }
    }

    public void editEmployee(int id, String newName, int age, String gender, String newWorkingType, String position) {
        for (int i = 0; i < employeeList.size(); i++) {
            if (id == employeeList.get(i).getId()) {
                employeeList.get(i).setName(newName);
                employeeList.get(i).setWorkingType(newWorkingType);
                employeeList.get(i).setAge(age);
                employeeList.get(i).setGender(gender);
                employeeList.get(i).setPosition(position);


                baseSalaryList.get(i).setName(newName);
                baseSalaryList.get(i).setWorkingType(newWorkingType);
                baseSalaryList.get(i).setPosition(position);
                baseSalaryList.get(i).setSalaryPerMonth(calculateBaseSalary(baseSalaryList.get(i).getPosition(), baseSalaryList.get(i).getWorkingType()));

            }
        }
}



    public List<Employee> findByName(String name){
        List<Employee> resultList = new ArrayList<>();
        for (Employee emp: employeeList) {
            if (emp.getName().toLowerCase(Locale.ROOT).contains(name.toLowerCase(Locale.ROOT))){
                resultList.add(emp);
            }
        }
        return resultList;
    }

    public void updateStatus(int id){
        boolean check = false;
        for (Employee emp: employeeList) {
            if(id == emp.getId()){
                emp.setStatus(!emp.isStatus());
                System.out.println("Update status for staff ID " + emp.getId() + " successful!");
                check = true;
            }
        }
        if (!check){
            System.out.println("Not found!");
        }
    }

    public List<Employee> filterByStatus(boolean status){
        List<Employee> resultList = new ArrayList<>();
        for (Employee emp: employeeList) {
            if(status == emp.isStatus()){
                resultList.add(emp);
            }
        }
        return resultList;
    }
    public List<Employee> filterByWorkingType(String workingType){
        List<Employee> resultList = new ArrayList<>();
        for (Employee emp: employeeList) {
            if(workingType.equalsIgnoreCase(emp.getWorkingType())){
                resultList.add(emp);
            }
        }
        return resultList;
    }
    public Employee findByID(int id){
        Employee employee = null;
        for (Employee emp: employeeList){
            if(id == emp.getId()){
                employee = emp;
                return employee ;
            }
        }
        return employee;
    }

}
