package view;

import controller.EmployeeController;
import controller.UserController;
import model.User;
import service.SalaryCalculation;
import io.ReaderAndWriter;
import model.Employee;
import model.Salary;
import service.UserService;
import validate.ValidateEmployee;
import java.util.List;
import java.util.Scanner;
import Main.Main;

public class ManagerView {
    private static final String MENU_FOR_MANAGER =
            "____________________________________"
                    + "\n|--------MENU FOR MANAGER--------|"
                    + "\n|Please choose any options to continue!"
                    + "\n                                                                "
                    + "\n|1. CREATE EMPLOYEE"
                    + "\n|2. SEARCH INFORMATION OF EMPLOYEE"
                    + "\n|3. CHECK STATUS OF EMPLOYEE"
                    + "\n|4. EDIT EMPLOYEE"
                    + "\n|5. UPDATE STATUS"
                    + "\n|6. DELETE EMPLOYEE"
                    + "\n|7. SHOW LIST OF EMPLOYEE"
                    + "\n|8. SHOW BASIC SALARY"
                    + "\n|9. SHOW ACTUAL SALARY"
                    + "\n|10. DELETE LOGIN ACCOUNT"
                    + "\n|11. SHOW USER LIST"
                    + "\n|12. LOG OUT"
                    + "\n Choose option: ";
    public final static String PATH_EMPLOYEE = ReaderAndWriter.PATH + "employee.txt";
    static Scanner scanner = new Scanner(System.in);
    static ValidateEmployee validateEmployee = new ValidateEmployee();
    static List<Employee> employeeList = new ReaderAndWriter<Employee>().readFromFile(PATH_EMPLOYEE);
    static SalaryCalculation salaryCalculation = new SalaryCalculation();
    static EmployeeController employeeController = new EmployeeController();
    static UserController userController = new UserController();


    public ManagerView(){
        System.out.println(MENU_FOR_MANAGER);
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
                showBasePayroll();
                break;
            case 9:
                showActualPayroll();
                break;
            case 10:
                deleteAccount();
                break;
            case 11:
                showUserList();
                break;
            case 12:
                new Main();
                break;
            default:
                System.err.println("Please choose any option!");
                new ManagerView();
        }
    }
    public static void creatEmployee(){
        int id = validateEmployee.validateID(employeeList);
        String name = validateEmployee.validateName();
        int age = validateEmployee.validateAge();
        String gender = validateEmployee.validateGender();
        String position = validateEmployee.validatePosition();
        String workingType = validateEmployee.validateWorkingType(position);
        Employee employee = new Employee(id, name, age, gender,true, workingType, position);
        employeeController.creatEmployee(employee);
        Salary baseSalary = new Salary(employee.getId(), employee.getName(), employee.getWorkingType(),employee.getPosition(), Salary.DEFAULT_WORKING_DAYS, salaryCalculation.calculateBaseSalary(employee.getPosition(), employee.getWorkingType()));
        salaryCalculation.creatBaseSalary(baseSalary);
        new ManagerView();
    }

    public static void showBasePayroll(){
        System.out.println(salaryCalculation.showBasePayroll());
        new ManagerView();
    }
    public static void showActualPayroll(){
        System.out.println(salaryCalculation.showActualPayroll());
        new ManagerView();
    }

    public static void showEmployeeList(){
        System.out.println(employeeController.writeEmpToFile());
        new ManagerView();
    }
    public static void checkStatus(){
        System.out.println("Enter the employee's name to check status: ");
        String name = scanner.nextLine();
        employeeController.checkStatusByName(name);
        new ManagerView();
    }
    public static void deleteEmployee(){
        System.out.println("Enter the employee's ID you want to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        employeeController.deleteById(id);
        new ManagerView();
    }

    public static void editEmployee(){
        int id = validateEmployee.validateEditEmployeeID();
        String newName = validateEmployee.validateName();
        int age = validateEmployee.validateAge();
        String gender = validateEmployee.validateGender();
        String position = validateEmployee.validatePosition();
        String newWorkingType = validateEmployee.validateEditWorkingType();
        employeeController.editEmployee(id, newName, age, gender, newWorkingType, position);
        new ManagerView();
    }
    public static void search(){
        System.out.println("==================== SEARCH BY ====================");
        System.out.println("1.STAFF'S NAME");
        System.out.println("2.WORKING TYPE");
        System.out.println("3.STATUS");
        System.out.println("Choose option:");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice){
            case 1:
                System.out.println("Enter employee's name you want to filter: ");
                String name = scanner.nextLine();
                System.out.println(employeeController.findByName(name));
                new ManagerView();
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
                    new ManagerView();
                }
                System.out.println(employeeController.filterByWorkingType(typeToSearch));
                new ManagerView();
                break;
            case 3:
                boolean status = validateEmployee.validateStatus();
                System.out.println(employeeController.filterByStatus(status));
                new ManagerView();
                break;

        }
    }
    public static void changeStatus(){
        System.out.println();
        System.out.println("Enter the employee's ID you want to update status: ");
        int id = Integer.parseInt(scanner.nextLine());
        employeeController.updateStatus(id);
        new ManagerView();
    }
    public static void deleteAccount(){
        System.out.println("Enter username you want to delete account: ");
        String userName = scanner.nextLine();
        userController.deleteAccount(userName);
        new ManagerView();
    }
    public static void showUserList(){
        for(User user: UserService.userList){
            System.out.println(user);
        }
        new ManagerView();
    }
}
