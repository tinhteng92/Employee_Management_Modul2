package view;

import modelAccount.SignUp;
import controller.UserController;
import service.UserService;
import validate.ValidateAccount;

import java.util.Scanner;

public class RegisterView {
    UserController userController = new UserController();
    UserService userService = new UserService();
    ValidateAccount validateAccount = new ValidateAccount();

    public RegisterView(){
        Scanner scanner = new Scanner(System.in);
        String displayName = validateAccount.validateDisplayName();
        String userName = validateAccount.validateUserName();
        String password = validateAccount.validatePassword();
        String role = validateAccount.validateRole();
        System.out.println("Registered successful!");

        SignUp signUp = new SignUp(displayName, userName, password, role);
        userController.register(signUp);
        System.out.println("Enter quit back to Menu: ");
        String backMenu = scanner.nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {
            new AccountView();
        }
    }
}
