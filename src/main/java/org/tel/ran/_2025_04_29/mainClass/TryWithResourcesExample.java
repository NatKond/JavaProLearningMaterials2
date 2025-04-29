package org.tel.ran._2025_04_29.mainClass;

import java.io.*;

public class TryWithResourcesExample {

    public static void main(String[] args) {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter("files/test.txt"));
            bufferedWriter.write("How doth the little crocodile\n" +
                    "Improve his shining tail,\n" +
                    "And pour the waters of the Nile\n" +
                    "On every golden scale!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }


        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("files/test.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
