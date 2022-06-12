package view;

import Main.Main;
import modelAccount.SignIn;
import controller.UserController;

import java.util.Scanner;

public class LoginView {
    Scanner scanner = new Scanner(System.in);
    UserController userController = new UserController();

    public LoginView() {
        System.out.println("------------ LOGIN FORM -----------");
        System.out.println("Enter your username: ");
        String username = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();
        SignIn signIn = new SignIn(username,password);
        String role=(userController.login(signIn));
        try {
            if (role.equalsIgnoreCase("manager")) {
                System.out.println("Welcome User: " + username);
                new ManagerView();
            } else if (role.equalsIgnoreCase("staff")) {
                System.out.println("Welcome User: " + username);
                new StaffView();
            } else if (role.equalsIgnoreCase("accountant")) {
                System.out.println("Welcome User: " + username);
                new AccountantView();
            } else {
                throw new Exception();
            }
        }catch (Exception e){
           System.err.println("Login failed! Please check your username or password.");
            new Main();
        }
    }
}
