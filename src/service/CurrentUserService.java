package service;

import io.ReaderAndWriter;
import model.CurrentUser;

import java.util.List;

public class CurrentUserService {
    public static final String PATH_CURRENT_USER = ReaderAndWriter.PATH + "currentUser.txt";
    public static List<CurrentUser> currentUserList = new ReaderAndWriter<CurrentUser>().readFromFile(PATH_CURRENT_USER);

    public static List<CurrentUser> writeToFile(){
        new ReaderAndWriter<CurrentUser>().writeToFile(PATH_CURRENT_USER, currentUserList);
        return currentUserList;
    }

    public void saveToList(CurrentUser currentUser){
        currentUserList.clear();
        currentUserList.add(currentUser);
    }

}
