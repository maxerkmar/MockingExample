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

    @Test
    @DisplayName("Handle new lines between numbers")
    void handleNewLinesBetweenNumbers() {
        int result = StringCalculator.add("1\n2,3");
        assertEquals(6, result);
    }

    @Test
    @DisplayName("Support different delimiters")
    void supportDifferentDelimiters() {
        int result = StringCalculator.add("//;\n1;2");
        assertEquals(3, result);
    }

    @Test
    @DisplayName("Throw exception for negative numbers")
    void throwExceptionForNegativeNumbers() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            StringCalculator.add("1,-2,3,-4");
        });

        String expectedMessage = "negatives not allowed: -2, -4";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("Ignore numbers larger than 1000")
    void ignoreNumbersLargerThan1000() {
        int result = StringCalculator.add("5,1001,5,1002");
        assertEquals(10, result);
    }
}
