package org.tel.ran._2025_04_29.mainClass;

import java.util.Arrays;

// TODO Написать метод который принимает n и возвращает массив длины n
// Данный код может выбросить два исключения, нужно поймать все и обработать

public class Exercise {

    public static void main(String[] args) {
        try {
            // System.out.println(Arrays.toString(getArray(-10)));
            System.out.println(Arrays.toString(getArray(0)));
            // System.out.println(Arrays.toString(getArray(1)));
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception : " + e.getMessage());
        } catch (NegativeArraySizeException e) {
            System.out.println("Negative Array Size Exception : " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array Index Out Of Bounds Exception : " + e.getMessage());
        }
//        } catch (ArithmeticException | NegativeArraySizeException | ArrayIndexOutOfBoundsException e) {
//            if (e instanceof ArithmeticException) {
//                System.out.println("Arithmetic Exception : " + e.getMessage());
//            } else if (e instanceof NegativeArraySizeException) {
//                System.out.println("Negative Array Size Exception : " + e.getMessage());
//            } else {
//                System.out.println("Array Index Out Of Bounds Exception : " + e.getMessage());
//            }
//        }


    }

    public static int[] getArray(int n) {
        int x = 10 / n;
        int[] y = new int[n];
        y[x] = 10;
        return y;
    }

    public static int[] generateArray(int n) {
        if (n < 0) {
            throw new RuntimeException("The number of elements in an array cannot be " + n);
        }
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            y[i] = i;
        }
        return y;
    }
}
