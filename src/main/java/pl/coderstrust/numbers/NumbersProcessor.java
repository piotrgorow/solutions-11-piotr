package pl.coderstrust.numbers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumbersProcessor {

    public String processLine(String line) {
        Pattern pattern = Pattern.compile("-?[0-9]+");
        Matcher matcher = pattern.matcher(line);
        StringBuilder result = new StringBuilder();
        int sum = 0;
        while (matcher.find()) {
            if (result.length() > 0 && Integer.parseInt(matcher.group()) >= 0) {
                result.append('+');
            }
            result.append(Integer.parseInt(matcher.group()));
            sum += Integer.parseInt(matcher.group());
        }
        if (result.length() > 0) {
            result.append("=" + sum);
        }
        return result.toString();
    }
}
