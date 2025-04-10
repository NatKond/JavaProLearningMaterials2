package org.tel.ran._2025_04_10.mainClass;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFileExample2 {
    public static void main(String[] args) {

        // Задача 1: Прочитайте файл descr_climates.txt и извлеките из него список климатов,
        // и запишите его в отдельный файл climates_list.txt

        StringBuilder sb = new StringBuilder(); //Объявляем StringBuilder для последовательного добавления строк

        //-------- Чтение файла ---------
        try (FileReader fileReader = new FileReader("files/descr_climates.txt")) { //Создаем поток ввода символов
            BufferedReader bufferedReader = new BufferedReader(fileReader); //Создаем объект для чтения потока
            String tmp = bufferedReader.readLine(); //Вкладываем строку во временную переменную

            while (!tmp.equals("{")) { //Читаем файл в цикле, пока не наткнемся на начало списка климатов
                tmp = bufferedReader.readLine(); //Читаем список климатов и вкладываем каждую строчку в StringBuilder
            }

            tmp = bufferedReader.readLine();
            while (!tmp.equals("}")) {
                sb.append(tmp.replace("\t", "").trim());
                sb.append("\n");
                tmp = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //-------- Запись файла ---------
        try (FileWriter fileWriter = new FileWriter("files/climates_list.txt")) { //Объявляем поток вывода символов
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(sb.toString()); //Записываем получившуюся в StringBuilder строку в файл
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Задача 2: Прочитайте файл descr_climates.txt и извлеките из него список климатов с heat больше 3.
        // Поместите получившиеся климаты в отдельный файл hot_climates.txt
        List<String> hotClimates = new ArrayList<>();
        try (FileReader fileReader = new FileReader("files/descr_climates.txt")) { //Создаем поток ввода символов

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String tmp = bufferedReader.readLine();
            while (tmp != null) { //Перебираем строки документа, пока не закончатся
                if (tmp.contains("climate ")) {  //Если наткнулись на строчку с климатом - сохраняем название климата
                    String climate = tmp.replace("climate ", "");

                    while (!tmp.contains("heat")) { //перебираем, пока не найдем температуру
                        tmp = bufferedReader.readLine();
                    }
                    tmp = tmp.replace("heat\t", "");

                    if (Integer.parseInt(tmp.trim()) > 2) { //Парсим число из символа и добавляем климат в список, если число больше 3
                        hotClimates.add(climate);
                    }
                }

                tmp = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (FileWriter fileWriter = new FileWriter("files/hot_climates.txt")) {
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for (String s : hotClimates) {
                writer.write(s);
                writer.write("\n");
            }
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
