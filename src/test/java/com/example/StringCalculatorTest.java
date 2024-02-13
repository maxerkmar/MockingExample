package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    @Test
    @DisplayName("Empty string should return 0")
    void emptyStringShouldReturnZero(){
        int result = StringCalculator.add("");
        assertEquals(0,result);
    }

    @Test
    @DisplayName("Single number should return the number itself")
    void singleNumberShouldReturnNumberItself(){
        int result = StringCalculator.add("1");
        assertEquals(1,result);
    }

    @Test
    @DisplayName("Two numbers separated by comma should return their sum")
    void twoNumbersSeparatedByCommaShouldReturnSum() {
        int result = StringCalculator.add("2,3");
        assertEquals(5, result);
    }

    @Test
    @DisplayName("Handle unknown amount of numbers separated by comma")
    void handleUnknownAmountOfNumbersSeparatedByComma() {
        int result = StringCalculator.add("1,2,3,4,5");
        assertEquals(15, result);
    }
}
