package view;
import java.util.*;

public class AccountView {
    public void AccountMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("====================== WELCOME =====================");
        System.out.println("1.REGISTER");
        System.out.println("2.LOGIN");
        System.out.println("3.Exit");
        System.out.println("Please choose menu: ");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                new RegisterView();
                break;
            case 2:
                new LoginView();
                break;
            case 3:
                System.exit(0);
            default:
                System.err.println("Please choose any option!");
                AccountMenu();
        }
    }
}
