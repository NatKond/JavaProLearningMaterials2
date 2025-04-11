package org.tel.ran._2025_04_11;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Task1 {
    public static void main(String[] args) {
        /*
        Задача 1: Прочитайте файл export_descr_guilds.txt и
        извлеките из него все пары значений Guild и building.
        Поместите эти пары в Map, а затем запишите получившиеся пары в
        файлы так, чтобы ключ был именем файла, а значение - содержимым
         */
        Map<String, String> guildBuildingMap = new HashMap<>();

        // ------- Чтение -------
        try (FileReader fileReader = new FileReader("files/export_descr_guilds.txt")) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            List<String> guilds = new ArrayList<>();
            List<String> buildings = new ArrayList<>();
            String tmp = bufferedReader.readLine();
            while (tmp != null) {
                if (tmp.matches("^Guild.*")) {
                    guilds.add(tmp.trim().split("\\s")[1]);
                }
                if (tmp.matches(".*building.*")) {
                    buildings.add(tmp.trim().split("\\s")[1]);
                }
                tmp = bufferedReader.readLine();
            }
            for (int i = 0; i < guilds.size() && i < buildings.size(); i++) {
                guildBuildingMap.put(guilds.get(i), buildings.get(i));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(guildBuildingMap);

        // ------- Запись -------
        for (Map.Entry<String, String> entry : guildBuildingMap.entrySet()) {
            try (FileWriter fileWriter = new FileWriter("files/guildBuilding/" + entry.getKey())) {
                fileWriter.write(entry.getValue());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
