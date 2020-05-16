import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int year = scanner.nextInt();
        int d1 = scanner.nextInt();
        int d2 = scanner.nextInt();
        int d3 = scanner.nextInt();

        System.out.println(LocalDate.ofYearDay(year, d1));
        System.out.println(LocalDate.ofYearDay(year, d2));
        System.out.println(LocalDate.ofYearDay(year, d3));
    }
}
