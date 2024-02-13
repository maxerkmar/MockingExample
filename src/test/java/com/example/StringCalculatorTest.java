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
}
