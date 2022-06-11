package view;

import model.CurrentUser;
import service.CurrentUserService;

import java.util.List;

public class ProfileView {

    public ProfileView() {
        List<CurrentUser> currentUserList = CurrentUserService.currentUserList;
        boolean checkPermission = currentUserList.get(0).getRole().equalsIgnoreCase("manager");
        System.out.println("Welcome User: " + currentUserList.get(0).getDisplayName());
        if(checkPermission){
           new ManagerView();
        }else {
           EmployeeView employeeView =new EmployeeView();
           employeeView.menuForStaff();
        }
    }

    public static void logOut(){
        CurrentUserService.currentUserList.clear();
        CurrentUserService.writeToFile();
    }

}
