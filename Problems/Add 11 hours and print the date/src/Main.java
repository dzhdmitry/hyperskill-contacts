import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDateTime time1 = LocalDateTime.parse(scanner.nextLine());
        LocalDateTime time2 = time1.plusHours(11L);

        System.out.println(time2.format(DateTimeFormatter.ISO_DATE));
    }
}
