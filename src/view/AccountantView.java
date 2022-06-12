package view;

import Main.Main;
import model.Employee;
import model.Salary;
import service.EmployeeService;
import service.SalaryCalculation;
import validate.ValidateAccount;
import validate.ValidateEmployee;

import java.util.Scanner;

import static view.ManagerView.employeeController;

public class AccountantView {
    private final String MENU_FOR_ACCOUNTANT =
            "____________________________________"
                    + "\n|------MENU FOR ACCOUNTANT------|"
                    + "\n|Please choose any options to continue!"
                    + "\n "
                    + "\n|1. CREAT SALARY"
                    + "\n|2. SHOW BASE SALARY"
                    + "\n|3. SHOW ACTUAL SALARY"
                    + "\n|4. SEARCH EMPLOYEE'S INFORMATION"
                    + "\n|5. SHOW LIST OF EMPLOYEE"
                    + "\n|6. LOG OUT"
                    + "\n Choose option:";

    Scanner scanner = new Scanner(System.in);
    EmployeeService employeeService = new EmployeeService();
    static SalaryCalculation salaryCalculation = new SalaryCalculation();
    ValidateEmployee validateEmployee = new ValidateEmployee();

    public AccountantView(){
        System.out.println(MENU_FOR_ACCOUNTANT);
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                creatSalary();
                break;
            case 2:
                showBasePayroll();
                break;
            case 3:
                showActualPayroll();
                break;
            case 4:
                search();
                break;
            case 5:
                showListEmployee();
                break;
            case 6:
                new Main();
                break;

        }
    }

    public void creatSalary(){
        int id = validateEmployee.validateEditEmployeeID();
        int workingDays = validateEmployee.validateWorkingDays();
        Employee employee = employeeService.findByID(id);
        try {
            if( employee != null){
                Salary actualSalary = new Salary(id, employee.getName(), employee.getWorkingType(),employee.getPosition(), workingDays, salaryCalculation.calculateActualSalary(employee.getPosition(), employee.getWorkingType(), workingDays));
                salaryCalculation.creatActualSalary(actualSalary);
            }else {
                throw new Exception();
            }
        }catch (Exception e){
            System.out.println("The ID is wrong, try again!");
        }

        new AccountantView();
    }

    public void showListEmployee(){
        System.out.println(employeeService.writeEmpToFile());
        new AccountantView();
    }
    public static void showBasePayroll(){
        System.out.println(salaryCalculation.showBasePayroll());
        new AccountantView();
    }
    public static void showActualPayroll(){
        System.out.println(salaryCalculation.showActualPayroll());
        new AccountantView();
    }
    public void search() {
        System.out.println("==================== SEARCH BY ====================");
        System.out.println("1.STAFF'S NAME");
        System.out.println("2.WORKING TYPE");
        System.out.println("3.STATUS");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice){
            case 1:
                System.out.println("Enter employee's name you want to filter: ");
                String name = scanner.nextLine();
                if(employeeService.findByName(name).isEmpty()){
                    System.out.println("Not found!");
                }else {
                    System.out.println(employeeService.findByName(name));
                }
                new AccountantView();
                break;
            case 2:
                System.out.println("Enter employee's working type you want to filter (PT - partTime/FT - fullTime): ");
                String workingType = scanner.nextLine();
                String typeToSearch = null;
                if (workingType.equalsIgnoreCase("pt")){
                    typeToSearch = "PartTime";
                }else if (workingType.equalsIgnoreCase("ft")){
                    typeToSearch = "FullTime";
                }else {
                    System.out.println("Invalid!");
                    new AccountantView();
                }
                if (employeeService.filterByWorkingType(typeToSearch) == null){
                    System.out.println("Not Found !");
                }else {
                    System.out.println(employeeService.filterByWorkingType(typeToSearch));
                }
                new AccountantView();
                break;
            case 3:
                boolean status = validateEmployee.validateStatus();
                System.out.println(employeeController.filterByStatus(status));
                new AccountantView();
                break;
        }
    }
}

