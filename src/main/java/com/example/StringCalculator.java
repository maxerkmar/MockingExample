package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {
    public static int add(String numbers) {
        if (numbers.isEmpty()) return 0;

        String delimiterRegex = "[,\n]";
        if (numbers.startsWith("//")) {
            Matcher matcher = Pattern.compile("^//((?:\\[(.+?)\\]|(.+?)))\n").matcher(numbers);
            if (matcher.find()) {
                String delimiters = matcher.group(1);
                numbers = numbers.substring(matcher.end() - matcher.start());
                delimiterRegex = parseDelimiters(delimiters);
            }
        }

        String[] numArr = numbers.split(delimiterRegex);
        int sum = 0;
        List<Integer> negatives = new ArrayList<>();
        for (String num : numArr) {
            if (!num.isEmpty()) {
                int n = Integer.parseInt(num);
                if (n < 0) negatives.add(n);
                else if (n <= 1000) sum += n;
            }
        }
        if (!negatives.isEmpty()) throw new IllegalArgumentException("negatives not allowed: " + negatives);
        return sum;
    }

    private static String parseDelimiters(String delimiters) {
        StringBuilder delimiterRegex = new StringBuilder();
        Matcher matcher = Pattern.compile("\\[(.*?)]").matcher(delimiters);
        while (matcher.find()) delimiterRegex.append("|").append(Pattern.quote(matcher.group(1)));
        return !delimiterRegex.isEmpty() ? delimiterRegex.substring(1) : Pattern.quote(delimiters);
    }
}