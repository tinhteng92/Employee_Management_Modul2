package view;

import io.ReaderAndWriter;
import model.User;
import validate.ValidateAccount;
import view.ManagerView;

import java.util.*;

public class AccountView {
    public static List<User> userList = new ArrayList<>();
    public final static String PATH_USER = ReaderAndWriter.PATH + "user.txt";

    static ReaderAndWriter<User> readerAndWriter = new ReaderAndWriter();
    public static User user;
    ValidateAccount validateAccount = new ValidateAccount();
    Scanner scanner = new Scanner(System.in);

    {
        userList = readerAndWriter.readFromFile(PATH_USER);
    }
    public static User userLogin;

    public void AccountMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("====================== WELCOME =====================");
        System.out.println("1.REGISTER");
        System.out.println("2.LOGIN");
        System.out.println("Please choose menu: ");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                RegisterView();
                break;
            case 2:
                LoginView();
                break;
            default:
                System.err.println("Please choose any option!");

        }
    }

    public void RegisterView() {
        String displayName = validateAccount.validateDisplayName();
        String userName = validateAccount.validateUserName();
        String password = validateAccount.validatePassword();
        String role = validateAccount.validateRole();

        user = new User(displayName, userName, password, role);
        userList.add(user);
        readerAndWriter.writeToFile(PATH_USER, userList);
        System.out.println("Enter EXIT back to Menu: ");
        String backMenu = scanner.nextLine();
        if (backMenu.equalsIgnoreCase("exit")) {
            AccountMenu();
        }

    }

    public void LoginView(){
        userLogin = loginMenu(userList);
        if (userLogin!= null){
            if(userLogin.getrole().equalsIgnoreCase("manager")){
                new ManagerView();
            }else if(userLogin.getrole().equalsIgnoreCase("staff")){
//                new StaffController();
            }
        }

    }
    public User loginMenu(List<User>userList){
        System.out.println("------------ LOGIN FORM -----------");
        System.out.println("Enter your username: ");
        String username = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();
        boolean check = true;
        User activeUser = null;
        for (int i = 0; i < userList.size(); i++) {
            if(username.equals(userList.get(i).getUserName()) && password.equals(userList.get(i).getPassword())){
                check = false;
                activeUser = userList.get(i);
                System.out.println("Login success!");
                break;
            }
        }
        if (check){
            return loginMenu(userList);
        }else {
            return activeUser;
        }
    }


}
