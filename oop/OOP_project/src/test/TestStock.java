package test;

import main.Stock;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestStock {
    public static void main(String[] args){
        String str1 = "Add scrip: INFY, sector: IT, O:880, H:890, L:900, C:910";
//        str1 = "Add user: Mimi, funds:1000 holding: {INFY:10, TCS:5, SBI:20}";
        str1 = "Add scrip: M&M, sector: Auto, O:610, H:610, L:610, C:610";

        String regexPattern = "(\\w+):( |)([\\w&]+)";
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(str1);
        StringBuilder info = new StringBuilder();
        while (matcher.find()) {
            System.out.print(matcher.group(1)+" | ");
            System.out.println(matcher.group(3));
            info.append(matcher.group(1)).append(',');
            info.append(matcher.group(3)).append(',');
        }
        String[] params = info.toString().split(",");
//        Stock s1 = new Stock(params);
//        System.out.println(s1);
    }
}