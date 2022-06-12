package controller;

import model.Employee;
import service.EmployeeService;

import java.util.List;

public class EmployeeController {
    EmployeeService employeeService = new EmployeeService();

    public void creatEmployee(Employee employee) {
        employeeService.saveToList(employee);
        employeeService.writeEmpToFile();
    }

    public List<Employee> writeEmpToFile(){
        return EmployeeService.employeeList;
    }

    public void deleteById(int id){
        employeeService.deleteById(id);
    }

    public void checkStatusByName(String name){
        employeeService.checkStatusByName(name);
    }
    public void editEmployee(int id, String newName, int age,String gender, String newWorkingType, String position){
        employeeService.editEmployee(id, newName, age, gender, newWorkingType, position);
    }

    public List<Employee> findByName(String name){
        return employeeService.findByName(name);
    }
    public void updateStatus(int id){
        employeeService.updateStatus(id);
    }

    public List<Employee> filterByStatus(boolean status){
        return employeeService.filterByStatus(status);
    }
    public List<Employee> filterByWorkingType(String workingType){
        return employeeService.filterByWorkingType(workingType);
    }
}
