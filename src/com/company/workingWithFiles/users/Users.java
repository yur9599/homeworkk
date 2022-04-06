package com.company.workingWithFiles.users;

import com.company.workingWithFiles.users.services.Services;
import com.company.workingWithFiles.users.services.impl.ServiceImpl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Users {

    private Users(){}

    public final static List<User> USERS = new ArrayList<>();

    public static void start() {
        Services services = new ServiceImpl();
        Scanner sc = new Scanner(System.in);
        File file = new File("users.txt");
        if (file.length()!=0) {
            try {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
                while (true){
                    try {
                        USERS.add((User) ois.readObject());
                    }
                    catch (EOFException e){
                        break;
                    }
                }
                ois.close();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        String command;
        while (true) {
            System.out.println("Enter command ");
            command=sc.nextLine();
            if (command.equals("EXIT")){
                try {
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("users.txt"));
                    for (User x:USERS) {
                        oos.writeObject(x);
                    }
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
            switch (command) {
                case ("LIST"):
                    for(User x:USERS){
                        System.out.println(x);
                    }
                    break;

                case ("ADD"):
                    String name;
                    String sureName;
                    int age;
                    System.out.print("Enter name ");
                    name= sc.nextLine();
                    System.out.print("Enter sureName ");
                    sureName= sc.nextLine();
                    System.out.print("Enter age ");
                    age=sc.nextInt();
                    sc.nextLine();
                    User user = new User(name,sureName,age);
                    services.add(user);
                    break;

                case ("REMOVE"):
                    String userName;
                    System.out.println("Enter userName ");
                    userName=sc.nextLine();
                    services.remove(userName);
                    break;

                default:
                    System.out.println("Invalid insert ");
            }
        }
    }

}
