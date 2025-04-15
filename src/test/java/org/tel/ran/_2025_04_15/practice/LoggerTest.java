package org.tel.ran._2025_04_15.practice;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class LoggerTest {

    private static String path = "files/log.txt";
    private static Logger logger = new Logger(false, path);

    @Test
    void infoTest() {
        logger.info("There was an incident.", this.getClass());

        String expected = "INFO : " + this.getClass().getName() + " - There was an incident.";
        String actual = getDataFromFile();

        Assertions.assertEquals(expected, actual.substring(actual.indexOf("INFO")));
    }

    @Test
    void errorTest() {
        logger.error("There was an incident.", this.getClass());
        String expected = "ERROR : " + this.getClass().getName() + " - There was an incident.";
        String actual = getDataFromFile();

        Assertions.assertEquals(expected, actual.substring(actual.indexOf("ERROR")));
    }

    private String getDataFromFile() {
        try (FileReader fileReader = new FileReader(path)) {
            BufferedReader reader = new BufferedReader(fileReader);
            StringBuilder output = new StringBuilder();
            while (reader.ready()) {
                output.append(reader.readLine());
            }
            return output.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterEach
    public void deleteFile() {
        File file = new File(path);
        if (file.exists()) {
            file.delete();
        }
    }
}