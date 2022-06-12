package validate;
import model.Employee;
import java.util.List;
import java.util.Scanner;

public class ValidateEmployee {
    Scanner scanner = new Scanner(System.in);

    public int validateID(List<Employee> employeeList) {
        while (true) {
            try {
                System.out.println("Enter employee's id, blanks are not allowed: ");
                int id = Integer.parseInt(scanner.nextLine());
                if (getIndexID(id, employeeList) != -1) {
                    throw new Exception();
                }
                return id;
            } catch (Exception e) {
                System.out.println("The ID is existing or Please enter number!");
            }
        }
    }

    public int getIndexID(int id, List<Employee> employeeList) {
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public String validateName(){
        while (true){
            System.out.println("Enter name: ");
            String str = scanner.nextLine();
            if (str.equals("")){
                System.out.println("Blanks are not allowed");
                continue;
            }
            return str;
        }
    }

    public int validateAge(){
        while (true){
            try {
                System.out.println("Enter age");
                int age = Integer.parseInt(scanner.nextLine());
                return age;
            }catch (Exception e){
                System.out.println("Please enter number!");
            }
        }
    }

    public String validateGender() {
        while (true) {
            try {
                System.out.println("Choose gender:");
                System.out.println("1. Male " );
                System.out.println("0. Female" );
                System.out.println("Enter \"1\" to choose Male, \"0\" to choose Female !");
                int choice = Integer.parseInt(scanner.nextLine());
                String gender;
                if (choice == 1) {
                    return gender = "Male";
                } else if (choice == 0) {
                    return gender = "Female";
                }
            } catch (Exception e) {
                System.out.println("Only enter \"1\" or \"0\" !");
            }
        }
    }
public String validatePosition() {
    while (true) {
        try {
            System.out.println("Choose position:");
            System.out.println("0. STAFF " );
            System.out.println("1. ACCOUNTANT" );
            System.out.println("2. MANAGER" );
            System.out.println("Enter \"0\" to choose STAFF, \"1\" to choose ACCOUNTANT or \"2\" to choose MANAGER !");
            int choice = Integer.parseInt(scanner.nextLine());
            String position;
            if (choice == 0) {
                return position = "STAFF";
            } else if (choice == 1) {
                return position = "ACCOUNTANT";
            } else if (choice == 2) {
                return position = "MANAGER";
            }
        } catch (Exception e) {
            System.out.println("Only enter \"0\" or \"1\" or \"2\"!");
        }
    }
}

    public String validateWorkingType(String position){
        while (true){
            String workingType;
            if (position.equalsIgnoreCase("manager") || position.equalsIgnoreCase("accountant")){
                return workingType = "FullTime";
            }
            if (position.equalsIgnoreCase("staff")){
                try {
                    System.out.println("Choose wokingType:");
                    System.out.println("1. PartTime ");
                    System.out.println("0. FullTime");
                    System.out.println("Enter \"1\" to choose PartTime, \"0\" to choose FullTime !");
                    int choice = Integer.parseInt(scanner.nextLine());
                    if (choice == 1) {
                        return workingType = "PartTime";
                    } else if (choice == 0) {
                        return workingType = "FullTime";
                    }
                } catch (Exception e) {
                    System.out.println("Only enter \"1\" or \"0\" !");
                }
            }
            }
        }
        public int validateEditEmployeeID(){
        while (true){
            try {
                System.out.println("Enter the staff's ID: ");
                int id = Integer.parseInt(scanner.nextLine());
                return id;
            }catch (Exception e){
                System.out.println("Enter number!");
            }
        }
        }

        public String validateEditWorkingType(){
        while (true){
            try {
                System.out.println("Enter new working type (PT - partTime/FT - fullTime): ");
                String newWorkingType = scanner.nextLine();
                String typeOfWorking = null;
                if(newWorkingType.equalsIgnoreCase("pt")|| newWorkingType.equalsIgnoreCase("ft")) {
                    System.out.println("Edit successful!");
                    if (newWorkingType.equalsIgnoreCase("pt")) {
                        typeOfWorking = "PartTime";
                    }
                    if (newWorkingType.equalsIgnoreCase("ft")) {
                        typeOfWorking = "FullTime";
                    }
                    return typeOfWorking;
                }   else {
                    throw new Exception();
                }
                }catch (Exception e) {
                    System.out.println("The working type failed! Please try again!");
                }

            }
        }
        public int validateWorkingDays(){
            while (true){
                try {
                    System.out.println("Enter working days");
                    int workingDays = Integer.parseInt(scanner.nextLine());
                    return workingDays;
                }catch (Exception e){
                    System.out.println("Please enter number!");
                }
            }
        }

        public boolean validateStatus(){
            while (true) {
                try {
                    System.out.println("Choose employee's working status you want to filter: ");
                    System.out.println("1. Working " );
                    System.out.println("0. Retired" );
                    System.out.println("Enter \"1\" to choose Working, \"0\" to choose Retired !");
                    int choice1 = Integer.parseInt(scanner.nextLine());
                    if (choice1 == 1) {
                       return true;
                    } else if (choice1 == 0) {
                        return false;
                    }
                } catch (Exception e) {
                    System.out.println("Only enter \"1\" or \"0\" !");
                }
            }
        }
}

