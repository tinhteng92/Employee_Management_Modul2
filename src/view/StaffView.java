package view;

import Main.Main;
import service.EmployeeService;

import java.util.Scanner;

public class StaffView {
    private final String MENU_FOR_STAFF =
            "____________________________________"
                    + "\n|------MENU FOR STAFF------|"
                    + "\n|Please choose any options to continue!"
                    + "\n"
                    + "\n|1. SEARCH EMPLOYEE'S INFORMATION"
                    + "\n|2. SHOW LIST OF EMPLOYEE"
                    + "\n|3. LOG OUT"
                    + "\n Choose option:";
    Scanner scanner = new Scanner(System.in);
    EmployeeService employeeService = new EmployeeService();

    public StaffView(){
        System.out.println(MENU_FOR_STAFF);
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                search();
                break;
            case 2:
                showListEmployee();
                break;
            case 3:
                new Main();
                break;
        }
    }

    public void showListEmployee(){
        System.out.println(employeeService.writeEmpToFile());
        new StaffView();
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
                new StaffView();
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
                    new StaffView();
                }
                if (employeeService.filterByWorkingType(typeToSearch) == null){
                    System.out.println("Not Found !");
                }else {
                    System.out.println(employeeService.filterByWorkingType(typeToSearch));
                }
                new StaffView();

                break;
            case 3:
                System.out.println("Enter employee's working status you want to filter(true - working/false - retired): ");
                boolean status = scanner.nextBoolean();
                scanner.nextLine();
                System.out.println(employeeService.filterByStatus(status));
                new StaffView();
                break;
        }
    }
}
