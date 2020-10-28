package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataExtract {
    public static String[] addRegex(String line){
        // extracting data with the help of regex
        String regexPattern = "(\\w+):( |)([\\w&]+)";
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(line);
        StringBuilder info = new StringBuilder();
        while (matcher.find()) {
            info.append(matcher.group(3)).append(',');
        }
        return info.toString().split(",");
    }
}
