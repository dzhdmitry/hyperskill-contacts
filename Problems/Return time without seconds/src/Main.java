import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        LocalTime time = LocalTime.parse(text);

        System.out.println(time.format(DateTimeFormatter.ofPattern("HH:mm")));
    }
}
