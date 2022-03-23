package com.company;

import java.sql.SQLException;
import java.util.Scanner;

public class EntryUser {

    public void entryUser(){


        Scanner sc = new Scanner(System.in);

        System.out.println("Вход в ноте" + "\n"+
                "Введите логин");

        String login = sc.next();

        System.out.println("Введите пароль");

        String pass = sc.next();

        DB db = new DB();

        try {
            if(db.isExistsUser(login,pass) == true){

                if(login.equals("Admin")==true){
                    UserPageAdmin.StartUserPage(login);
                }
                System.out.println("");

                MenuUser eu = new MenuUser();
                eu.mu(login);

            }else {
                System.out.println("Неверный логин или пароль.\n" +
                        "1. Повторить попытку входа.\n"+
                        "2. Выйти в меню.");

                int choice = sc.nextInt();

                if (choice == 1){
                    entryUser();
                }
                if (choice == 2){
                    Menu.startMenu();
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
