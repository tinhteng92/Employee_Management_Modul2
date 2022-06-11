package controller;
import modelAccount.SignIn;
import modelAccount.SignUp;
import model.CurrentUser;
import model.User;
import service.CurrentUserService;
import service.UserService;

public class UserController {
    UserService userService = new UserService();
    CurrentUserService currentUserService = new CurrentUserService();

    public void register(SignUp signUp){
        int id;
        if (UserService.userList.size() == 0) {
            id = 1;
        } else {
            id = (UserService.userList.get(UserService.userList.size() - 1).getId()) + 1;
        }
        User user = new User(id, signUp.getDisplayName(), signUp.getUsername(), signUp.getPassword(), signUp.getRole());
        userService.saveToList(user);
        userService.writeToFile();
    }
    public boolean login(SignIn signIn) {
        if (userService.checkLogin(signIn.getUsername(), signIn.getPassword())) {
            User user = userService.searchByUserName(signIn.getUsername());
            CurrentUser currentUser = new CurrentUser(user.getId(), user.getDisplayName(), user.getUserName(), user.getPassword(), user.getRole());
            currentUserService.saveToList(currentUser);
            currentUserService.writeToFile();
            return true;
        } else {
            return false;
        }
    }
    public void deleteAccount(String username){
        userService.deleteByUserName(username);
    }

}
