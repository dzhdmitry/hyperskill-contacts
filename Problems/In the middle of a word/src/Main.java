import java.util.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String part = scanner.nextLine();
        String line = scanner.nextLine();
        Pattern pattern = Pattern.compile("\\S" + part.toLowerCase() + "\\S");
        Matcher matcher = pattern.matcher(line.toLowerCase());

        if (matcher.find()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}