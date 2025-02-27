import java.util.regex.*;

public class Regex {
    public static void main(String[] args) {
        // Generates a random string containing first name and surname
        String s = "Joel George is my name. Joel is an ex footballer. George is his dad's first name. He wants to go to Cybersecurity. Joel George is a pupil.";
        String regexString = "\\b[j]\\w*[l]\\b|\\b[g]\\w*[e]\\b";

        // Compiles the regular expression pattern
        Pattern pattern = Pattern.compile(regexString, Pattern.CASE_INSENSITIVE);

        // Creates a matcher for the given string and the pattern
        Matcher matcher = pattern.matcher(s);

        // Initializes a count variable to keep track of matches
        int count = 0;

        // Iterates through the matches
        while (matcher.find()) {
            count++;
            // Prints the match index and the matched substring
            System.out.println("Found: " + count + " = "
                    + matcher.start() + " - " + matcher.end());
            System.out.println(s.substring(matcher.start(), matcher.end()));
        }
    }
}

