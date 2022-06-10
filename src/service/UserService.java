package service;

import io.ReaderAndWriter;
import model.CurrentUser;
import model.User;

import java.util.List;

public class UserService {
    public final static String PATH_USER = ReaderAndWriter.PATH + "user.txt";
    public static List<User> userList = new ReaderAndWriter<User>().readFromFile(PATH_USER);
    List<CurrentUser> currentUserList = CurrentUserService.currentUserList;

    public List<User> writeToFile(){
        new ReaderAndWriter<User>().writeToFile(PATH_USER, userList);
        return userList;
    }
    public void saveToList(User user){
        userList.add(user);
    }

    public void deleteByUserName(String username){
        if (!existedByUserName(username)) {
            System.err.println("User is not exit!");
        }
        for (int i = 0; i < userList.size(); i++) {
            // chu y phan adminList.get(0), vì người dùng hiện tại là manager, đang đăng nhập, ko thể tự xóa chính mình, tránh trường hợp đánh nhầm.
            if (currentUserList.get(0).getUsername().equals(username)){
                System.err.println("This user is active. It cannot be deleted!");
                break;
            }else {
                if (username.equals(userList.get(i).getUserName())){
                    userList.remove(i);
                    System.out.println("Deleted username " + username + " successful!");
                    break;
                }
            }
        }
    }
    public boolean existedByUserName (String username){
        for (int i = 0; i < userList.size(); i++) {
            if(username.equals(userList.get(i).getUserName())){
                return true;
            }
        }
        return false;
    }
    public boolean checkLogin(String username, String password){
        for (int i = 0; i < userList.size(); i++) {
            if(username.equals(userList.get(i).getUserName()) && password.equals(userList.get(i).getPassword())){
                return true;
            }
        }
        return false;
    }

    public User searchByUserName(String username){
        for (int i = 0; i < userList.size(); i++) {
            if(username.equals(userList.get(i).getUserName())){
                return userList.get(i);
            }
        }
        return null;
    }
}
