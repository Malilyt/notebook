package com.company;

import java.sql.SQLException;

public class Test {

    public static void main(String[] args){
        DB dbtest = new DB();

        try {
            dbtest.isExistsNumber("Николай Генов");
        } catch (SQLException |ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
