package org.tel.ran._2025_04_08.mainClass;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        String path = "/Users/nkond/IdeaProjects/JavaProLearningMaterials2/files";
        File folder = new File(path);
        System.out.println("Exists? " + folder.exists());
        System.out.println("Is it a folder? " + folder.isDirectory());
        System.out.println("Length = " + folder.length());
        System.out.println(folder.getPath());
        System.out.println(folder.getParent());
        System.out.println(Arrays.toString(folder.list()));
        File[] files = folder.listFiles();
        assert files != null;
        for (File file : files) {
            System.out.println(file);
        }
        System.out.println();

        String path1 = "files/test1.txt";
        File file1 = new File(path1);
        System.out.println("Exists? " + file1.exists());
        System.out.println("Is it a folder? " + file1.isDirectory());
        System.out.println("Length = " + file1.length());
        System.out.println(file1.getPath());
        System.out.println(file1.getParent());

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
    }
}
