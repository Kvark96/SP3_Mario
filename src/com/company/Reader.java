package com.company;

import java.io.*;
import java.sql.SQLException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.*;
import org.apache.ibatis.jdbc.ScriptRunner;

import static com.company.JDBCConnection.*;

public class Reader {


    public static void readPizzaMenu() throws SQLException {
        int bSize = 30;


        setup();

        try {
            PreparedStatement Drop = con.prepareStatement("Drop Table IF EXISTS PizzaMenu;");
            Drop.execute();
            PreparedStatement Create = con.prepareStatement("\n" +
                    "CREATE TABLE PizzaMenu(\n" +
                    "\tPID INTEGER  NOT NULL AUTO_INCREMENT primary Key,\n" +
                    "    Name VARCHAR(30),\n" +
                    "    Ingredients VARCHAR(200)\n" +
                    "   );");
            Create.execute();
            PreparedStatement statement = con.prepareStatement("INSERT INTO PizzaMenu (Name, Ingredients) VALUES(?,?)");
            File file = new File("src/PizzaMenu.csv");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            int count = 0;

            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                String Name = data[0];
                String Ingredients = data[1];


                statement.setString(1, Name);
                statement.setString(2, Ingredients);

                statement.addBatch();

                if (count % bSize == 0) {
                    statement.executeBatch();
                }
            }
            reader.close();

            statement.executeBatch();





        } catch (SQLException | IOException e) {
            System.err.println(e);

        }


    }


    public static void readPizzaID() throws SQLException {
        int bSize = 30;
        try {
            PreparedStatement use = con.prepareStatement("use mario2;");
            use.executeQuery();

            PreparedStatement Drop = con.prepareStatement("Drop Table IF EXISTS PizzaID;");
            Drop.execute();
            PreparedStatement Create = con.prepareStatement("  CREATE TABLE PizzaID(\n" +
                    "\tPID INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
                    "    Price INTEGER\n" +
                    "    );");
            Create.execute();
            PreparedStatement statement = con.prepareStatement("INSERT INTO PizzaID (Price) VALUES(?)");
            File file = new File("src/PizzaID.csv");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            int count = 0;

            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] data1 = line.split(";");
                int Price = Integer.parseInt(data1[0]);


                statement.setInt(1, Price);

                statement.addBatch();

                if (count % bSize == 0) {
                    statement.executeBatch();
                }
            }
            reader.close();

            statement.executeBatch();



        } catch (SQLException | IOException e) {
            e.printStackTrace();
            System.err.println(e);

        }


    }

    public static void runSQL() throws FileNotFoundException {
        ScriptRunner sr = new ScriptRunner(con);
        File sqlFile = new File("database.sql");
        BufferedReader sqlReader = new BufferedReader(new FileReader(sqlFile));
        sr.runScript(sqlReader);
    }

    public static void displayPizzaMenu() throws SQLException {
        Statement SelectPizzastoPrint = con.createStatement();
        String getData = "select * from PizzaMenu ;";

        ResultSet PizzaDatas = SelectPizzastoPrint.executeQuery(getData);
        while (PizzaDatas.next()) {
            String PID = PizzaDatas.getString(1);
            String Name = PizzaDatas.getString(2);
            String Ingredients = PizzaDatas.getString(3);
            System.out.println("Pizza nummer: " + PID);
            System.out.println("Navn:" +Name);
            System.out.println("Indeholder:" + Ingredients);
            System.out.println("");


        }

    }

}
