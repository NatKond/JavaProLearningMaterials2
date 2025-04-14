package org.tel.ran._2025_04_10.practice;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

/**
 * Реализовать логирование стектрейса Exception со временем ошибки в файл errors.log
 */

public class Task1 {
    public static void main(String[] args) {
        String path = "files/errors.log";
        try {
            Scanner scanner = new Scanner(System.in);
            int i = Integer.parseInt(scanner.nextLine());
            System.out.println(1/i);
        } catch (Exception error) {
            try (FileWriter fileWriter = new FileWriter(path,true)){
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                StringBuilder log = new StringBuilder();
                for (StackTraceElement stackTraceElement : error.getStackTrace()) {
                    log.append(stackTraceElement).append("\n");
                }
                log.append(new Date()).append("\n\n");
                bufferedWriter.write(log.toString());
            } catch(IOException _){
                throw new RuntimeException();
            }
        }
    }
}
