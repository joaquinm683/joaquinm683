package com.isil.sesion1;

import java.sql.*;

public class MainApp {

    public static void main(String[] args) throws Exception {
        //System.out.println("Hello World");
        // 1. Cargar drive
        // 2. crear conexion
        //3 creat statement
        //4. ejecutar query
        //5. recorrer resultatods
        //6. Cerrar conexion

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TEST",
                "root",
                "EsUnSQL_2022");

        Statement stmt = con.createStatement();
        int resultUpdate = stmt.executeUpdate("update Users set City='Rosario' where name= 'Messi'");



        Statement stmt2 = con.createStatement();

        ResultSet resultSet = stmt2.executeQuery("select * from Users where name ='Ronaldo'");
        while(resultSet.next()){

            System.out.println(resultSet.getString("name") + "\n" +
                    ""+ resultSet.getString("phone") + "\n"+
                    resultSet.getString("city")
            );
        }

        PreparedStatement preparedStatement = con.prepareStatement("select * from Users where name=? and city=?");

        preparedStatement.setString(1,"Cueva");
        preparedStatement.setString(2,"Lima");
        ResultSet resultSet2 = preparedStatement.executeQuery();

        Statement stCreate = con.createStatement();
        int affectedRows = stCreate.executeUpdate("UPDATE Users set name='juan' where iduser=1");

        System.out.println("Affected Rows" + affectedRows);
      PreparedStatement preparedStatement1 = con.prepareStatement("select * from Users where iduser=?");
      preparedStatement1.setInt(1,1);

      ResultSet resultSet3= preparedStatement1.executeQuery();





        while(resultSet3.next()){

           System.out.println(resultSet3.getString("name") + "\n" +
                   ""+ resultSet3.getString("phone") + "\n"+
                    resultSet3.getString("city")
           );
        }
        con.close();
    }


}
