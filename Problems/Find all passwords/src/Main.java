import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        Pattern pattern = Pattern.compile("password:?\\s*([A-Za-z0-9]+)\\b", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        boolean found = false;

        while (matcher.find()) {
            if (matcher.groupCount() == 1) {
                System.out.println(matcher.group(1));

                found = true;
            }
        }

        if (!found) {
            System.out.println("No passwords found.");
        }
    }
}
