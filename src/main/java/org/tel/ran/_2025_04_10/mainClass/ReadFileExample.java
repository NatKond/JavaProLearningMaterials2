package org.tel.ran._2025_04_10.mainClass;

import java.io.*;
import java.util.*;

public class ReadFileExample {
    public static void main(String[] args) {
        StringBuilder input = new StringBuilder();
        try (FileReader fileReader = new FileReader("files/descr_climates.txt")) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                input.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Задача 1: Прочитайте файл descr_climates.txt и извлеките из него список климатов,
        // и запишите его в отдельный файл climates_list.txt
        String inputString = input.toString();
        int indexClimates = inputString.indexOf("climates");
        int indexStart = inputString.indexOf('{', indexClimates) + 1;
        int indexEnd = inputString.indexOf('}', indexStart);
        String[] climates = inputString.substring(indexStart, indexEnd).replace("\t", "").trim().split("\n");

        System.out.println(Arrays.toString(climates));

        try (FileWriter fileWriter = new FileWriter("files/climates_names.txt")) {
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (String s : climates) {
                bufferedWriter.write(s);
                bufferedWriter.write("\n");
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Задача 2: Прочитайте файл descr_climates.txt и извлеките из него список климатов с heat больше 3.
        // Поместите получившиеся климаты в отдельный файл hot_climates.txt
        Map<String,Integer> climateHeatMap = new HashMap<>();
        for (String climate : climates) {
            int indexStartClimate = inputString.indexOf("climate " + climate);
            int indexStartHeat = inputString.indexOf("heat", indexStartClimate) + 4;
            int indexEndHeat = inputString.indexOf("\n", indexStartHeat);
            String heat = inputString.substring(indexStartHeat, indexEndHeat).replace("\t", "".trim());
            climateHeatMap.put(climate,Integer.parseInt(heat));
        }
        System.out.println(climateHeatMap);
        List<String> hotClimates = climateHeatMap.entrySet().stream()
                .filter(entry -> entry.getValue() > 3)
                .map(Map.Entry::getKey)
                .toList();

        System.out.println(hotClimates);
    }
}
