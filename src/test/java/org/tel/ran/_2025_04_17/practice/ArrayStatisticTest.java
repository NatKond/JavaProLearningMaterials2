package org.tel.ran._2025_04_17.practice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ArrayStatisticTest {

    @ParameterizedTest
    @MethodSource("arrayProvider")
    void findMaxPositiveCase(int[] array, int expectedMax) {
        assertEquals(expectedMax, ArrayStatistic.findMax(array));
    }

    static Stream<Arguments> arrayProvider() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of(new int[]{1, 2, 3}, 3),
                org.junit.jupiter.params.provider.Arguments.of(new int[]{4, 5, 1}, 5),
                org.junit.jupiter.params.provider.Arguments.of(new int[]{-1, -5, -3}, -1)
        );
    }

    @ParameterizedTest
    @NullAndEmptySource
    void findMaxNegativeCase(int[] array) {
        assertThrows(IllegalArgumentException.class, () -> ArrayStatistic.findMax(array),"Input array is null or empty.");
    }
}