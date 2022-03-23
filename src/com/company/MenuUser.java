package com.company;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuUser {

    public static void mu(String login){
        Scanner sc = new Scanner(System.in);
        System.out.println("Вы вошли в ноте под логином: "+login + "\n"+
                "1. Найти номер.\n"+
                "2. Добавить номер.\n"+
                "3. Посмтотреть все добавленые номера.\n" +
                "4. Удалить добавленый контакт.\n"+
                "5. Выйти из аккаунта.");


        int choiceInMenuUser = sc.nextInt();

        if(choiceInMenuUser == 1){
            System.out.println("Введите имя и фамилию");
            String name = sc.nextLine();
            String name2 = sc.nextLine();


            DB db = new DB();
            try {
                db.isExistsNumber(name+name2);


            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            MenuUser.mu(login);

        }

        if(choiceInMenuUser == 2){
            AddNumberPhone.Add(login);
            MenuUser.mu(login);
            System.out.println("");
        }

        if(choiceInMenuUser == 3){
            DB db = new DB();
            try {
                db.checkAddNumber(login);

            } catch (SQLException |ClassNotFoundException e) {
                e.printStackTrace();
            }
            MenuUser.mu(login);

        }

        if(choiceInMenuUser == 4){
            System.out.println("Введите имя и фамилию контакта.");
            String name1 = sc.nextLine();
            String name2 = sc.nextLine();
            String name= name1+name2;

            System.out.println("Введите номер контакта.");
            String number_phone = sc.nextLine();

         DB db = new DB();
            try {
                db.deleteNumber(login, name, number_phone);

            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            MenuUser.mu(login);
        }

        if (choiceInMenuUser == 5){
            Menu.startMenu();
        }
    }
}
