package com.company;

import java.sql.SQLException;
import java.util.Scanner;

public class AddNumberPhone  {

    public static void Add(String login){


        Scanner sc = new Scanner(System.in);

        System.out.println("Введите имя и фамилию");
        String name = sc.nextLine();
        System.out.println("Введите номер телефона");
        String numberPhone = sc.nextLine();

        System.out.println("Вы ходите добавить " + name + " с номером " + numberPhone + " ?\n" +
                "1. Да\n" +
                "2. Нет");
        int choiceAddNumber = OnlyNumber.playerInput();

        if(choiceAddNumber != 1 && choiceAddNumber != 2){
            System.out.println("Введён вариант, которого не существует. Повторите попытку.\n");
            Add(login);
        }

        if (choiceAddNumber == 2){
            Menu.startMenu();
        }

        if (choiceAddNumber == 1) {
            DB db = new DB();

            try {
                db.insertPhone(name, numberPhone, login);

            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println("Добавлен "+ name + " с номером " + numberPhone );
        }
    }
}
