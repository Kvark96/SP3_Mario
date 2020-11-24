package com.company;

import java.io.IOException;
import java.sql.SQLException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
