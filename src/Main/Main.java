package Main;
import view.AccountView;


public class Main {
    public static void main(String[] args) {
        AccountView accountView = new AccountView();
        while (true){
            accountView.AccountMenu();
        }
    }
}

