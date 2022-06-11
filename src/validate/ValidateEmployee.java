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
                System.out.println("Please enter number!");
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

    public String validateString(String name1, String name2, String name3) {
        while (true) {
            try {
                System.out.println("Choose:" + name1);
                System.out.println("1. " + name2);
                System.out.println("0. " + name3);
                System.out.println("Enter \"1\" to choose " + name2 + " \"0\" to choose " + name3 +"!");
                int choice = Integer.parseInt(scanner.nextLine());
                String str;
                if (choice == 1) {
                    return str = name2;
                } else if (choice == 0) {
                    return str = name3;
                }
            } catch (Exception e) {
                System.out.println("Only enter \"1\" or \"0\" !");
            }
        }
    }

    public String validateWorkingType(String position){
        while (true){
            String workingType;
            if (position.equalsIgnoreCase("manager")){
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
                System.out.println("Enter the staff's ID you want to edit: ");
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
}

