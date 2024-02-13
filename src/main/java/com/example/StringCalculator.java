package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {
    public static int add(String numbers) {
        if(numbers.isEmpty()) return 0;
        String delimiter = "[,\n]";
        if (numbers.startsWith("//")) {
            int delimiterIndex = numbers.indexOf("\n");
            delimiter = numbers.substring(2, delimiterIndex);
            numbers = numbers.substring(delimiterIndex + 1);
        }
        String[] numArr = numbers.split(delimiter);
        int sum = 0;
        List<Integer> negatives = new ArrayList<>();
        for (String num : numArr){
            int n = Integer.parseInt(num);
            if (n<0) negatives.add(n);
            else if (n <= 1000) sum += n;
        }
        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("negatives not allowed: " + negatives.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(", ")));
        }
        return sum;
    }
}
