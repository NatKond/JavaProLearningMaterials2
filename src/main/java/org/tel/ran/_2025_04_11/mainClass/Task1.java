package org.tel.ran._2025_04_11.mainClass;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

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
            String tmp = bufferedReader.readLine();
            String currentGuild = null;
            String currentBuilding = null;
            while (tmp != null) {
                if (tmp.matches("^Guild.*")) {
                    currentGuild = tmp.trim().split("\\s")[1];
                }
                if (tmp.matches(".*building.*") ) {
                    currentBuilding = tmp.trim().split("\\s")[1];

                }
                if (currentGuild != null && currentBuilding != null){
                    guildBuildingMap.put(currentGuild,currentBuilding);
                    currentGuild = null;
                    currentBuilding = null;
                }
                tmp = bufferedReader.readLine();
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
