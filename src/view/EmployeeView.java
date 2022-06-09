package view;

import service.EmployeeService;

import java.util.Scanner;

public class EmployeeManagement {
    Scanner scanner = new Scanner(System.in);
    EmployeeService employeeService = new EmployeeService();

    public void menuForStaff(){
        System.out.println("==================== MENU FOR STAFF ====================");
        System.out.println("Please choose any options: ");
        System.out.println("1.SEARCH EMPLOYEE'S INFORMATION");
        System.out.println("2.SHOW LIST OF EMPLOYEE");
        System.out.println("3.LOG OUT");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                search();
                break;
            case 2:
                showListEmployee();
                break;
            case 3:
                ProfileView.logOut();
                new Main();
        }
    }

    public void backMenuForStaff(){
        String backMenu = "";
        while (!backMenu.equalsIgnoreCase("exit")){
            System.out.println("ENTER \"EXIT\" TO COME BACK MENU: ");
            backMenu = scanner.nextLine();
            if (backMenu.equalsIgnoreCase("exit")){
                menuForStaff();
            }
        }
    }
    public void showListEmployee(){
        System.out.println(employeeService.writeEmpToFile());
        backMenuForStaff();
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
                System.out.println(employeeService.findByName(name));
                backMenuForStaff();
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
                    menuForStaff();
                }
                System.out.println(employeeService.filterByWorkingType(typeToSearch));
                backMenuForStaff();
                break;
            case 3:
                System.out.println("Enter employee's working status you want to filter(true - working/false - retired): ");
                boolean status = scanner.nextBoolean();
                scanner.nextLine();
                System.out.println(employeeService.filterByStatus(status));
                backMenuForStaff();
                break;
        }
    }
}
