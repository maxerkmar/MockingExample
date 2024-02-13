package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {
    public static int add(String numbers) {
        if(numbers.isEmpty()) return 0;
        String delimiter = "[,\n]";
        if (numbers.startsWith("//")) {
            Matcher matcher = Pattern.compile("//\\[(.*?)]\n?(.*)").matcher(numbers);
            if (matcher.find()) {
                delimiter = Pattern.quote(matcher.group(1));
                numbers = matcher.group(2);
            } else {
                delimiter = Pattern.quote(numbers.substring(2, 3));
                numbers = numbers.substring(4);
            }
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
