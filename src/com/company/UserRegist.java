package com.company;

import java.sql.SQLException;
import java.util.Scanner;

public class UserRegist {

    public static void userRegist () {

        Scanner sc = new Scanner(System.in);
// придумать выход
        System.out.println("Регистрация в ноте.\n" +
                "Если хотите выйти в меню укажите логин цифрой '0'. \n"+
                "1.Введите логин.");
        String login = sc.next();

        System.out.println("Введите пароль");
        String pass = sc.next();

        DB db = new DB();

        try {
            if(login.equals(String.valueOf(0))){
                Menu.startMenu();
            }

            if(db.checkDoubleUser(login)== true){
                System.out.println("Вы не можете использовать этот логин.\n"+
                        "Пожалуйста, придумайте другой.\n");
                UserRegist.userRegist();
            }

            if(db.checkDoubleUser(login)== false){

                db.insertUser(login, PassHash.md5String(pass));
                System.out.println("Вы были зарегестрированы!\n");
                Menu.startMenu();
            }


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
