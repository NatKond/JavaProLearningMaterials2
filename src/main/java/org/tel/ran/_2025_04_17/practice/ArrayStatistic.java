package org.tel.ran._2025_04_17.practice;

import java.util.Arrays;

public class ArrayStatistic {

    public static int findMax(int[] array){
        if (array == null || array.length == 0){
            throw new IllegalArgumentException("Input array is null or empty.");
        }
        return Arrays.stream(array).max().orElseThrow();
    }

    public static int findMin(int[] array){
        if (array == null || array.length == 0){
            throw new IllegalArgumentException("Input array is null or empty.");
        }
        return Arrays.stream(array).min().orElseThrow();
    }

    public static double findAverage(int[] array){
        if (array == null || array.length == 0){
            throw new IllegalArgumentException("Input array is null or empty.");
        }
        return Arrays.stream(array).average().orElseThrow();
    }
}
