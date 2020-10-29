package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataExtract {
    public static String[] paramsRegex(String line){
        // extracting data with the help of regex
        // regex pattern
        String regexPattern = "(\\w+):( |)([\\w&]+)";
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(line);
        // store result in a string
        StringBuilder info = new StringBuilder();
        while (matcher.find()) {
            // group 3 is the group after ':' e.g. in scrip: INFY, INFY is the third group
            info.append(matcher.group(3)).append(',');
        }
        // return a list of string as arguments
        return info.toString().split(",");
    }
}
