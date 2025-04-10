package org.tel.ran._2025_04_10.mainClass;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws IOException {
        //Использование байтового потока
        InputStream inputStream = new FileInputStream("files/somefile.txt");
        try (inputStream) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        }

        //Использование символьного потока
        FileReader fileReader = new FileReader("files/somefile.txt");
        try (fileReader) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
        }

        //Записываем тестовые данные байтовым потоком вывода
        FileOutputStream outputStream = new FileOutputStream("files/somefile");
        String stringToWrite = "1; login12312; nameHello";

        try (outputStream) {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            bufferedOutputStream.write(stringToWrite.getBytes());
            bufferedOutputStream.flush();
        }

        //Записываем тестовые данные символьным потоком вывода
        FileWriter writer = new FileWriter("files/somefile");
        try (writer) {
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(stringToWrite);
            bufferedWriter.flush();
        }

        //Использование байтового потока

        try ( FileInputStream inputStream2 = new FileInputStream("file/somefile")) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream2);
            byte[] arr = new byte[bufferedInputStream.available()];
            while (bufferedInputStream.read(arr) != -1) {
                System.out.println("Я записываю данные в виде байт");
            }
            String s = new String(arr);
            System.out.println("Результат записи: " + s);
        }

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("file/somefile"))) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            String result = baos.toString(StandardCharsets.UTF_8);
            System.out.println(result);
        }


        //Использование символьного потока
        try (FileReader fileReader2 = new FileReader("file/somefile")) {
            BufferedReader bufferedReader = new BufferedReader(fileReader2);
            StringBuilder sb = new StringBuilder();
            while (bufferedReader.read() != -1) {
                sb.append(bufferedReader.readLine()); // запись данных в
                System.out.println("Я записываю данные в виде символов");
            }
            System.out.println("Результат записи: " + sb);
        }
    }
}
