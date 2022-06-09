package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReaderAndWriter<T>{
    public static final String PATH = "C:\\CodeGym\\Hoc-lieu-Java\\DemoCode\\Modul-2\\Case_Study\\src\\data\\";

    public List<T> readFromFile(String path) {
        List<T> typeList = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fis);
            typeList = (List<T>) objectInputStream.readObject();
            objectInputStream.close();
            fis.close();
        } catch (FileNotFoundException e) {
            System.out.println("Danh sách không tồn tại !");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return typeList;
    }

    public void writeToFile(String path, List<T> typeList) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fos);
            objectOutputStream.writeObject(typeList);
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("File chưa tồn tại !");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
