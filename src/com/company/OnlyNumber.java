package com.company;

import java.util.Scanner;

public class OnlyNumber {

    static int number;


    public static int playerInput(){
        System.out.println(" ");
        System.out.println("Выберете действие: ");
        Scanner playerInput = new Scanner(System.in);
        if(playerInput.hasNextInt()) {
            number = playerInput.nextInt();
        } else {
            System.out.println("Вы ввели не целое число или несуществующий вариант.");
            playerInput();
        }
        return number;
    }
}
