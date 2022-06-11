package service;
import io.ReaderAndWriter;
import model.Employee;
import model.Salary;
import java.util.ArrayList;
import java.util.List;
import static controller.SalaryCaculation.calculateSalary;
import static controller.SalaryCaculation.salaryList;

public class EmployeeService {
    public final static String PATH_EMPLOYEE = ReaderAndWriter.PATH + "employee.txt";
    ReaderAndWriter<Employee> readerAndWriter = new ReaderAndWriter();
    public final static String PATH_SALARY = ReaderAndWriter.PATH + "salary.txt";
    public static List<Employee> employeeList = new ArrayList<>();
    {
        employeeList = readerAndWriter.readFromFile(PATH_EMPLOYEE);
    }

    public void creatEmployee(Employee employee) {
        saveToList(employee);
        writeEmpToFile();

    }

    public List<Employee> writeEmpToFile(){
        readerAndWriter.writeToFile(PATH_EMPLOYEE, employeeList);
        return employeeList;
    }

    public void saveToList(Employee employee){
        employeeList.add(employee);
    }
    public void deleteById(int id){
        boolean check = false;
        for (int i = 0; i < employeeList.size(); i++) {
            if(id == employeeList.get(i).getId()){
                employeeList.remove(i);
                salaryList.remove(i);
                readerAndWriter.writeToFile(PATH_EMPLOYEE, employeeList);
                System.out.println("Delete successful");
                check = true;
                break;
            }
        }
        if (!check){
            System.out.println("Not found!");
        }
    }
    public void checkStatusByName(String name){
        List<Employee> resultList = new ArrayList<>();
        boolean check = false;
        for (int i = 0; i < employeeList.size(); i++) {
            if (name.equalsIgnoreCase(employeeList.get(i).getName())){
                Employee employee = new Employee(name, employeeList.get(i).isStatus());
                resultList.add(employee);
                check = true;
            }
        }
        if (!check){
            System.out.println("Not found");
        }
        for(Employee emp: resultList){
            System.out.println(emp.toStringStatus());
        }
    }
    public void editEmployee(int id, String newName, int age,String gender, String newWorkingType){
        for (int i = 0; i < employeeList.size(); i++) {
            if(id == employeeList.get(i).getId()){
                if(employeeList.get(i).getPosition().equalsIgnoreCase("staff")){
                    employeeList.get(i).setName(newName);
                    employeeList.get(i).setWorkingType(newWorkingType);
                    employeeList.get(i).setAge(age);
                    employeeList.get(i).setGender(gender);
                    salaryList.get(i).setName(newName);
                    salaryList.get(i).setWorkingType(newWorkingType);
                    salaryList.get(i).setSalaryPerMonth(calculateSalary(salaryList.get(i).getPosition(), salaryList.get(i).getWorkingType()));
                }else {
                    employeeList.get(i).setName(newName);
                    salaryList.get(i).setName(newName);
                }
                new ReaderAndWriter<Salary>().writeToFile(PATH_SALARY,salaryList);
            }
        }
    }

    public List<Employee> findByName(String name){
        List<Employee> resultList = new ArrayList<>();
        for (int i = 0; i < employeeList.size(); i++) {
            if (name.equalsIgnoreCase(employeeList.get(i).getName())){
                resultList.add(employeeList.get(i));
            }
        }
        return resultList;
    }

    public void updateStatus(int id){
        boolean check = false;
        for (int i = 0; i < employeeList.size(); i++) {
            if(id == employeeList.get(i).getId()){
                employeeList.get(i).setStatus(!employeeList.get(i).isStatus());
                System.out.println("Update status for staff ID " + employeeList.get(i).getId() + " successful!");
                check = true;
            }
        }
        if (!check){
            System.out.println("Not found!");
        }
    }

    public List<Employee> filterByStatus(boolean status){
        List<Employee> resultList = new ArrayList<>();
        for (int i = 0; i < employeeList.size(); i++) {
            if(status == employeeList.get(i).isStatus()){
                resultList.add(employeeList.get(i));
            }
        }
        return resultList;
    }
    public List<Employee> filterByWorkingType(String workingType){
        List<Employee> resultList = new ArrayList<>();
        for (int i = 0; i < employeeList.size(); i++) {
            if(workingType.equalsIgnoreCase(employeeList.get(i).getWorkingType())){
                resultList.add(employeeList.get(i));
            }
        }
        return resultList;
    }
}
