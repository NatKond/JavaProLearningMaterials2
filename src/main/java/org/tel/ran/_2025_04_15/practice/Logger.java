package org.tel.ran._2025_04_15.practice;

import java.io.*;
import java.time.LocalDateTime;

public class Logger {
    private boolean doAppend = true;
    private String path;

    public Logger(boolean doAppend, String path) {
        this.doAppend = doAppend;
        this.path = path;
    }

    public Logger(String path) {
        this.path = path;
    }

    public void info(String message, Class<?> clazz) {
        add(message, clazz, MessageType.INFO);
    }

    public void error(String message, Class<?> clazz) {
        add(message, clazz, MessageType.ERROR);
    }

    private void add(String message, Class<?> clazz, MessageType messageType) {
        try (FileWriter fileWriter = new FileWriter(path, doAppend)) {
            BufferedWriter writer = new BufferedWriter(fileWriter);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(LocalDateTime.now())
                    .append(" ")
                    .append(messageType)
                    .append(" : ")
                    .append(clazz.getName())
                    .append(" - ")
                    .append(message)
                    .append("\n");
            writer.write(stringBuilder.toString());
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
