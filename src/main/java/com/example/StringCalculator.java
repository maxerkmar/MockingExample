package com.example;

public class StringCalculator {
    public static int add(String numbers) {
        if(numbers.isEmpty()) return 0;
        String[] numArr = numbers.split(",");
        int sum = 0;
        for (String num : numArr) sum += Integer.parseInt(num);
        return sum;
    }
}
