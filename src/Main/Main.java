package Main;
import view.AccountView;
import view.EmployeeView;
import view.ManagerView;

public class Main {
    public static void main(String[] args) {
        AccountView accountView = new AccountView();
        while (true){
            accountView.AccountMenu();
        }
    }
}

