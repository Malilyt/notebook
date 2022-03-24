package com.company;

import java.sql.SQLException;
import java.util.Scanner;

public class UserPageAdmin {

    public static void StartUserPage (String login) {

        Scanner sc = new Scanner(System.in);
        DB db = new DB();

        System.out.println("Телефонный справочник.\n" +
                "1. Добавить контакт в справочник.\n" +
                "2. Узнать номер телефона.\n" +
                "3. Удалить добавленый контакт.");

        int choiceInMenu = OnlyNumber.playerInput();

        if(choiceInMenu != 1 && choiceInMenu != 2 && choiceInMenu != 3){
            System.out.println("Введён вариант, которого не существует. Повторите попытку.\n");
            StartUserPage(login);
        }

        if (choiceInMenu==1) {
            AddNumberPhone.Add(login);
        }

        if (choiceInMenu==2) {

            System.out.println("Введите имя и фамилию");
            String name = sc.nextLine();
            String name2 = sc.nextLine();


            try {

                db.isExistsNumber(name+name2);
                System.out.println("\n");
                UserPageAdmin.StartUserPage(login);

            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        if (choiceInMenu==3) {
            System.out.println("Введите имя и фамилию контакта.");
            String name1 = sc.nextLine();
            String name2 = sc.nextLine();
            String name= name1+name2;

            System.out.println("Введите номер контакта.");
            String number_phone = sc.nextLine();

            try {
            db.deleteNumberAdmin(name,number_phone);

            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }
}
