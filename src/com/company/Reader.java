package com.company;

import java.io.*;
import java.util.Scanner;

/// shit work :)

public class Reader {
    public static void main(String[] args) throws IOException {
        // open file input stream
        BufferedReader reader = new BufferedReader(new FileReader(
                "Pizzaer.csv"));
        // read file line by line
        String line = null;
        Scanner scanner = null;
        int index = 0;


        while ((line = reader.readLine()) != null) {

            scanner = new Scanner(line);
            System.out.println(line);
        }
    }
}
        /*
        String filename = "Pizzaer.csv";
        File file = new File(filename);
        System.out.println(file.length());
        try {
            Scanner input = new Scanner(file);
            while (input.hasNext()) {
                String data = input.next();
                System.out.println(data);
            }
            input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


         */
