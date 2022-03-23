package com.company;

import java.util.Scanner;

public class Menu {

    public static void startMenu () {

        Scanner sc = new Scanner(System.in);

        System.out.println("Телефонный справочник.\n" +
                "1. Войти в ноте.\n" +
                "2. Зарегестрироваться в ноте.\n"+
                "3. Выйти из ноте.");

        int choiceInMenu = sc.nextInt();

        if (choiceInMenu==1) {
            EntryUser eu = new EntryUser();
            eu.entryUser();
        }

        if (choiceInMenu==2) {
            UserRegist.userRegist();
        }

        if (choiceInMenu==3){
            System.exit(0);
        }



    }
}
