package validate;
import model.User;
import java.util.Scanner;
import java.util.regex.Pattern;
import static service.UserService.userList;

public class ValidateAccount {
    Scanner scanner = new Scanner(System.in);


    public String validateDisplayName() {
        System.out.println("Enter your display name, blank is not allowed: ");
        while (true) {
            String displayName = scanner.nextLine();
            boolean checkDisplayName = Pattern.matches("(.|\\s)*\\S(.|\\s)*", displayName);
            if (!checkDisplayName) {
                System.err.println("The display name failed! Please enter again!");
                continue;
            }
            return displayName;
        }
    }
    public boolean userNameHas(String newUserName) {
        for (User acc :userList) {
            if (acc.getUserName().equals(newUserName)) {
                return true;
            }
        }
        return false;
    }
    public String validateUserName(){
        System.out.println("Enter your username which is required to lowercase letters or numbers, at least 4 characters, no whitespace: ");
        while (true) {
            String userName = scanner.nextLine();
            boolean checkUserName = Pattern.matches("[a-z0-9_]{4,}", userName);
            if (!checkUserName) {
                System.err.println("Username failed! Please try again!");
                continue;
            } else if (userNameHas(userName)) {
                System.err.println("Username is existed! Please try again!");
                continue;
            }
            return userName;
        }
    }
    public String validatePassword(){
        System.out.println("Enter your password which is required at least 4 characters, contain at least one digit, one lowercase & uppercase letter, one special character and no whitespace:");
        while (true) {
            String password = scanner.nextLine();
            boolean checkPassword = Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%&+^!*=])(?=\\S+$).{4,}$", password);
            if (!checkPassword) {
                System.err.println("Password failed! Please try again!");
                continue;
            }
            return password;
        }
    }
    public String validateRole() {
        while (true) {
            try {
                System.out.println("Choose position: ");
                System.out.println("1.STAFF ");
                System.out.println("0. MANAGER ");
                System.out.println("Enter \"1\" to choose STAFF" + " \"0\" to choose MANAGER !");
                int choice = Integer.parseInt(scanner.nextLine());
                String position;
                if (choice == 1) {
                    return position = "STAFF";
                } else if (choice == 0) {
                    return position = "MANAGER";
                }
            } catch (Exception e) {
                System.out.println("Only enter \"1\" or \"0\" !");
            }
        }
    }
}
