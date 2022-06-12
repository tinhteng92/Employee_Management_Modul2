package controller;
import modelAccount.SignIn;
import modelAccount.SignUp;
import model.User;
import service.UserService;

public class UserController {
    UserService userService = new UserService();

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
    public String login(SignIn signIn) {
        String position = null;
        if (userService.checkLogin(signIn.getUsername(), signIn.getPassword())) {
            User user = userService.searchByUserName(signIn.getUsername());
            position = user.getRole();
        }
        return position;
    }

    public void deleteAccount(String username){
        userService.deleteByUserName(username);
    }

}
