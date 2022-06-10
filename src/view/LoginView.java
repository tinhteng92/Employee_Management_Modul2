package view;

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
        if (userController.login(signIn)){
            new ProfileView();
        }else {
            System.err.println("Login failed! Please check your username or password.");
            new LoginView();
        }
    }
}
