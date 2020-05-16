import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int end = LocalDate.of(year, month, 1).lengthOfMonth();

        for (int i=1; i<=end; i++) {
            LocalDate date = LocalDate.of(year, month, i);

            if (date.getDayOfWeek() == DayOfWeek.MONDAY) {
                System.out.println(date);
            }
        }
    }
}
