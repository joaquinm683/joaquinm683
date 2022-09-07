package com.isil.sesion1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainApp {

    public static void main(String[] args) throws Exception {
        //System.out.println("Hello World");


        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TEST",
                "root",
                "EsUnSQL_2022");

        Statement stmt = con.createStatement();
        int resultUpdate = stmt.executeUpdate("update Users set City='Rosario' where name= 'Messi'");

        ResultSet result = stmt.executeQuery("select * from Users where name='Messi'");

        while(result.next()){

            System.out.println(result.getString("idUser"));
            System.out.println(result.getString("name"));
            System.out.println(result.getString("phone"));
            System.out.println(result.getString("city"));

        }
    }


}
