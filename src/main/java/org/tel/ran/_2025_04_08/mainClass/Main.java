package org.tel.ran._2025_04_08.mainClass;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        String path1 = "files/test1.txt";
        File file1 = new File(path1);
        OutputStream outputStream = new FileOutputStream(file1);
        String output = "Hello Java!";
        outputStream.write(output.getBytes());
        outputStream.close();

        System.out.println(output);

        String path2 = "files/test2.txt";
        File file2 = new File(path2);
        InputStream inputStream = new FileInputStream(file2);
        byte[] b = inputStream.readAllBytes();
        String input = new String(b);
        System.out.println(input);

        /*
        Scanner scanner = new Scanner(System.in);
        System.out.println("Пожалуйста, введите id:");
        String id = scanner.nextLine();
        System.out.println("Пожалуйста, введите login:");
        String login = scanner.nextLine();
        System.out.println("Пожалуйста, введите серию паспорта:");
        int passportSeries = scanner.nextInt();
        System.out.println("Пожалуйста, введите номер паспорта:");
        int passportNumber = scanner.nextInt();
        User user = new User(id, login, passportSeries, passportNumber);
        OutputStream outputStream = new FileOutputStream("/Users/nkond/test/user.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(user);
        objectOutputStream.close();

        InputStream inputStream = new FileInputStream("/Users/nkond/test/user.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        User user1 = (User) objectInputStream.readObject();
        System.out.println(user1);
         */
        
    }
}
