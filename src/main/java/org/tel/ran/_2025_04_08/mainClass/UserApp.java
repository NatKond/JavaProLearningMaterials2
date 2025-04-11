package org.tel.ran._2025_04_08.mainClass;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class UserApp {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        InputStream inputStream = new FileInputStream("files/countries");
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        List<String> countries = (List<String>) objectInputStream.readObject();
        System.out.println(countries);

        Random random = new Random();
        OutputStream fileOutput = new FileOutputStream("files/users_raw");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutput);
        List<User> usersOut = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            usersOut.add(new User("id_" + UUID.randomUUID(), "login_" + UUID.randomUUID(), random.nextInt(1000, 9999), random.nextInt(1000, 9999)));
        }
        objectOutputStream.writeObject(usersOut);

        ObjectInputStream objectInputStream1 = new ObjectInputStream(new FileInputStream("files/users_raw"));
        List<User> usersIn = (List<User>) objectInputStream1.readObject();
        Map<Integer, List<User>> userSeriesMap = usersIn.stream()
                .collect(Collectors.groupingBy(user -> (user.getPassportNumber() / 1000) * 1000));
        for (Map.Entry<Integer, List<User>> entry : userSeriesMap.entrySet()) {
            ObjectOutputStream userOutputStream = new ObjectOutputStream(
                    new FileOutputStream("files/users/users" + entry.getKey() + "-" + (entry.getKey() + 999))
            );
            userOutputStream.writeObject(entry.getValue());
        }

        ObjectInputStream usersInputStream = new ObjectInputStream(new FileInputStream("files/users/users1000-1999"));
        List<User> users1000 = (List<User>) usersInputStream.readObject();
        System.out.println(users1000);
    }
}
