import java.util.*;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String line = scanner.nextLine();

        Pattern pp = Pattern.compile("\\b[A-Za-z]{" + size + "}\\b");
        Matcher mm = pp.matcher(line);

        if (mm.find()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
