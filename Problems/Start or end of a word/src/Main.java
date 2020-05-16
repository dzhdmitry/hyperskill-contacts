import java.util.*;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String part = scanner.nextLine().toLowerCase();
        String line = scanner.nextLine().toLowerCase();

        if (containsPattern("\\W" + part, line) ||
            containsPattern(part + "\\W", line) ||
            line.endsWith(part) ||
            line.startsWith(part))
        {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static boolean containsPattern(String pattern, String line) {
        return Pattern.compile(pattern).matcher(line).find();
    }
}
