import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] parts = line.split("\\.");

        if (parts.length != 4 || !line.matches("\\d{1,3}.\\d{1,3}.\\d{1,3}.\\d{1,3}")) {
            System.out.println("NO");

            return;
        }

        for (String part: parts) {
            if (part.matches("\\d{1,2}")) {
                continue;
            }

            if (!part.matches("\\d{3}")) {
                System.out.println("NO");

                return;
            }

            if (!part.matches("2[0-5][0-5]") && !part.matches("1\\d{2}")) {
                System.out.println("NO");

                return;
            }
        }

        System.out.println("YES");
    }
}
