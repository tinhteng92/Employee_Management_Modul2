package view;

import controller.UserController;
import service.EmployeeService;
import controller.SalaryCaculation;
import io.ReaderAndWriter;
import model.Employee;
import model.Salary;
import service.UserService;
import validate.ValidateEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerView {
    public final static String PATH_EMPLOYEE = ReaderAndWriter.PATH + "employee.txt";
    static Scanner scanner = new Scanner(System.in);
    static ValidateEmployee validateEmployee = new ValidateEmployee();
    ReaderAndWriter<Employee> readerAndWriter = new ReaderAndWriter();
    static List<Employee> employeeList = new ArrayList<>();
    static SalaryCaculation salaryCaculation = new SalaryCaculation();
    static EmployeeService employeeService = new EmployeeService();
    static UserController userController = new UserController();

   public ManagerView(){
       employeeList = readerAndWriter.readFromFile(PATH_EMPLOYEE);
   }

    public static void menuForManager(){
        System.out.println("==================== MENU FOR MANAGER ====================");
        System.out.println("1.CREATE EMPLOYEE");
        System.out.println("2.SEARCH INFORMATION OF EMPLOYEE");
        System.out.println("3.CHECK STATUS OF EMPLOYEE");
        System.out.println("4.EDIT EMPLOYEE");
        System.out.println("5.UPDATE STATUS");
        System.out.println("6.DELETE EMPLOYEE");
        System.out.println("7.SHOW LIST OF EMPLOYEE");
        System.out.println("8.SHOW SALARY");
        System.out.println("9.DELETE LOGIN ACCOUNT");
        System.out.println("10.SHOW USER LIST");
        System.out.println("11.LOG OUT");
        System.out.println("Please choose any options: ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                creatEmployee();
                break;
            case 2:
                search();
                break;
            case 3:
                checkStatus();
                break;
            case 4:
                editEmployee();
                break;
            case 5:
                changeStatus();
                break;
            case 6:
                deleteEmployee();
                break;
            case 7:
                showEmployeeList();
                break;
            case 8:
                showPayroll();
                break;
            case 9:
                deleteAccount();
                break;
            case 10:
                showUserList();
                break;
            case 11:
                ProfileView.logOut();
                //
                new AccountView();
            default:
                System.err.println("Please choose any option!");
                menuForManager();
        }
    }
    private static void backMenuForManager() {
        String backMenu = "";
        while (!backMenu.equalsIgnoreCase("quit")) {
            System.out.println("ENTER \"EXIT\" TO COME BACK MENU: ");
            backMenu = scanner.nextLine();
            if (backMenu.equalsIgnoreCase("exit")) {
                menuForManager();
            }
        }
    }
    public static void creatEmployee(){
        int id = validateEmployee.validateID(employeeList);
        String name = validateEmployee.validateName();
        int age = validateEmployee.validateAge();
        String gender = validateEmployee.validateString("gender", "Male", "Female");
        String position = validateEmployee.validateString("position", "Staff", "Manager");
        String workingType = validateEmployee.validateWorkingType(position);
        Employee employee = new Employee(id, name, age, gender,true, workingType, position);
        employeeService.creatEmployee(employee);
        Salary employeeSalary = new Salary(employee.getId(), employee.getName(), employee.getWorkingType(),employee.getPosition(), Salary.DEFAULT_WORKING_DAYS, salaryCaculation.calculateSalary(employee.getPosition(), employee.getWorkingType()));
        salaryCaculation.creatSalary(employeeSalary);
        backMenuForManager();
    }

    public static void showPayroll(){
        System.out.println(salaryCaculation.showPayroll());
        backMenuForManager();
    }
    public static void showEmployeeList(){
        System.out.println(employeeService.writeEmpToFile());
        backMenuForManager();
    }
    public static void checkStatus(){
        System.out.println("Enter the employee's name to check status: ");
        String name = scanner.nextLine();
        employeeService.checkStatusByName(name);
        backMenuForManager();
    }
    public static void deleteEmployee(){
        System.out.println("Enter the employee's ID you want to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        employeeService.deleteById(id);
        backMenuForManager();
    }

    public static void editEmployee(){
        int id = validateEmployee.validateEditEmployeeID();
        String newName = validateEmployee.validateName();
        int age = validateEmployee.validateAge();
        String gender = validateEmployee.validateString("gender", "Male", "Female");
        String newWorkingType = validateEmployee.validateEditWorkingType();
        employeeService.editEmployee(id, newName, age,gender, newWorkingType);
        backMenuForManager();
    }
    public static void search(){
        System.out.println("==================== SEARCH BY ====================");
        System.out.println("1.STAFF'S NAME");
        System.out.println("2.WORKING TYPE");
        System.out.println("3.STATUS");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice){
            case 1:
                System.out.println("Enter employee's name you want to filter: ");
                String name = scanner.nextLine();
                System.out.println(employeeService.findByName(name));
                backMenuForManager();
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
                    menuForManager();
                }
                System.out.println(employeeService.filterByWorkingType(typeToSearch));
                backMenuForManager();
                break;
            case 3:
                System.out.println("Enter employee's working status you want to filter(true - working/false - retired): ");
                boolean status = scanner.nextBoolean();
                scanner.nextLine();
                System.out.println(employeeService.filterByStatus(status));
                backMenuForManager();
                break;
        }
    }
    public static void changeStatus(){
        System.out.println();
        System.out.println("Enter the employee's ID you want to update status: ");
        int id = Integer.parseInt(scanner.nextLine());
        employeeService.updateStatus(id);
        backMenuForManager();
    }
    public static void deleteAccount(){
        System.out.println("Enter username you want to delete account: ");
        String userName = scanner.nextLine();
        userController.deleteAccount(userName);
        backMenuForManager();
    }
    public static void showUserList(){
        System.out.println(UserService.userList);
        backMenuForManager();
    }
}
