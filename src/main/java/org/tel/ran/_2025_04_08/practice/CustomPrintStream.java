package org.tel.ran._2025_04_08.practice;

import java.io.*;
import java.util.Arrays;

public class CustomPrintStream extends PrintStream {

    private String path = "files/console.txt";
    private FileOutputStream fileOutputStream = new FileOutputStream(path);

    public CustomPrintStream(OutputStream out) throws FileNotFoundException {
        super(out);
    }

    @Override
    public void write(byte[] buf, int off, int len) {
        StringBuilder sb = new StringBuilder();
        byte[] bufReverse = new byte[buf.length];
        for (int i = off, j = len - 1; i < len && j >= off; i++, j--) {
            bufReverse[j] = buf[i];
            sb.append((char) buf[i]);
        }

        super.write(buf, off, len);
        try {
            // fileOutputStream.write(buf, off, len);
            fileOutputStream.write(bufReverse, off, len);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
