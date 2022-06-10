package view;

import model.CurrentUser;
import service.CurrentUserService;

import java.util.List;

public class ProfileView {
    static CurrentUserService currentUserService = new CurrentUserService();

    public ProfileView() {
        List<CurrentUser> currentUserList = CurrentUserService.currentUserList;
        boolean checkPermission = currentUserList.get(0).getRole().equalsIgnoreCase("manager");
        System.out.println("Welcome User: " + currentUserList.get(0).getName());
        if(checkPermission){
            new ManagerView();
        }else {
            new EmployeeView();
        }
    }

    public static void logOut(){
        CurrentUserService.currentUserList.clear();
        currentUserService.writeToFile();
    }

}
