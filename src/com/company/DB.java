package com.company;


import java.sql.*;



public class DB {

    private final String HOST = "127.0.0.1";
    private final String PORT = "3306";
    private final String DB_NAME = "note";
    private final String LOGIN = "root";
    private final String PASS = "";

    private Connection dbConn = null;

    private Connection getDbConnection () throws ClassNotFoundException, SQLException {
        String connStr = "jdbc:mysql://" +HOST + ":" + PORT + "/" + DB_NAME;
        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConn = DriverManager.getConnection(connStr, LOGIN, PASS);
        return dbConn;
    }

    public void isConnected () throws SQLException, ClassNotFoundException {
        dbConn = getDbConnection();
        System.out.println(dbConn.isValid(1000));
    }


    public void insertPhone (String name, String number_phone, String login) throws SQLException, ClassNotFoundException{
        String addPhoneStr = "INSERT INTO `phone` (name, number_phone, login) VALUES(?,?,?)";

        PreparedStatement prSt = getDbConnection().prepareStatement(addPhoneStr);
        prSt.setString(1, name);
        prSt.setString(2, number_phone);
        prSt.setString(3, login);

        prSt.executeUpdate();
    }

    public void insertUser (String login, String pass) throws SQLException, ClassNotFoundException{
        String addPhoneStr = "INSERT INTO `users` (login, pass) VALUES(?,?)";

        PreparedStatement prSt = getDbConnection().prepareStatement(addPhoneStr);
        prSt.setString(1, login);
        prSt.setString(2, pass);

        prSt.executeUpdate();
    }


    public boolean isExistsUser (String login, String pass) throws SQLException, ClassNotFoundException {
        String sql = "SELECT `id` FROM `users` WHERE `login` = ? AND `pass` = ?";


            PreparedStatement prSt = getDbConnection().prepareStatement(sql);

            prSt.setString(1, login);
            prSt.setString(2, pass);

        ResultSet res = prSt.executeQuery();
        boolean resBol = res.next();

        return resBol;


    }

    public void isExistsNumber (String name) throws SQLException, ClassNotFoundException {
        String sql = "SELECT `id` FROM `phone` WHERE `name` = ?";
        PreparedStatement prSt = getDbConnection().prepareStatement(sql);

        prSt.setString(1, name);

        ResultSet rs = prSt.executeQuery();

        while (rs.next()) {
            int count = rs.getInt(1);
            String sql2= "SELECT `number_phone` FROM `phone` WHERE `id` = ?";
            PreparedStatement prSt2 = getDbConnection().prepareStatement(sql2);

            prSt2.setInt(1, count);

            ResultSet rs2 = prSt2.executeQuery();
            while (rs2.next()) {
                String number_phone = rs2.getString(1);

                    System.out.println("Номер телефона: " + number_phone + "\n");

            }
        }
    }

    public void checkAddNumber (String login) throws SQLException, ClassNotFoundException {
        String sql = "SELECT `id` FROM `phone` WHERE `login` = ?";
        PreparedStatement prSt = getDbConnection().prepareStatement(sql);

        prSt.setString(1, login);

        ResultSet rs = prSt.executeQuery();

        while (rs.next()) {
            int count = rs.getInt(1);
            String sql2= "SELECT * FROM `phone` WHERE `id` = ?";
            PreparedStatement prSt2 = getDbConnection().prepareStatement(sql2);

            prSt2.setInt(1, count);

            ResultSet rs2 = prSt2.executeQuery();
            while (rs2.next()) {
                String number_phone = rs2.getString(3);
                String name = rs2.getString(2);
                System.out.println(name + " телефон: " + number_phone);
            }
        }
    }

    public void deleteNumber (String login, String name, String number_phone) throws SQLException, ClassNotFoundException{
        String sql = "SELECT `id` FROM `phone` WHERE `login` = ? AND `name` = ? AND `number_phone` = ?";
        PreparedStatement prSt = getDbConnection().prepareStatement(sql);

        prSt.setString(1, login);
        prSt.setString(2, name);
        prSt.setString(3, number_phone);

        ResultSet rs = prSt.executeQuery();

        while (rs.next()) {
            int count = rs.getInt(1);
            String sql2 = "DELETE FROM `phone` WHERE `id` = ?";
            PreparedStatement prSt2 = getDbConnection().prepareStatement(sql2);

            prSt2.setInt(1, count);
            prSt2.executeUpdate();

            System.out.println("Контакт удалён");
        }
    }

    public void deleteNumberAdmin (String name, String number_phone) throws SQLException, ClassNotFoundException{
        String sql = "SELECT `id` FROM `phone` WHERE `name` = ? AND `number_phone` = ?";
        PreparedStatement prSt = getDbConnection().prepareStatement(sql);


        prSt.setString(2, name);
        prSt.setString(3, number_phone);

        ResultSet rs = prSt.executeQuery();

        while (rs.next()) {
            int count = rs.getInt(1);
            String sql2 = "DELETE FROM `phone` WHERE `id` = ?";
            PreparedStatement prSt2 = getDbConnection().prepareStatement(sql2);

            prSt2.setInt(1, count);
            prSt2.executeUpdate();

            System.out.println("Контакт удалён");
        }
    }

    public boolean checkDoubleUser (String login) throws SQLException, ClassNotFoundException{
        String sql = "SELECT `id` FROM `users` WHERE `login` = ? ";


        PreparedStatement prSt = getDbConnection().prepareStatement(sql);
        prSt.setString(1, login);


        ResultSet res = prSt.executeQuery();
        boolean resBol = res.next();

        return resBol;
    }

}
