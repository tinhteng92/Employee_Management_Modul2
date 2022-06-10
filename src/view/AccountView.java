package view;

import io.ReaderAndWriter;
import model.User;
import validate.ValidateAccount;
import view.ManagerView;

import java.util.*;

public class AccountView {
    public void AccountMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("====================== WELCOME =====================");
        System.out.println("1.REGISTER");
        System.out.println("2.LOGIN");
        System.out.println("Please choose menu: ");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                new RegisterView();
                break;
            case 2:
                new LoginView();
                break;
            default:
                System.err.println("Please choose any option!");
                AccountMenu();
        }
    }
}
