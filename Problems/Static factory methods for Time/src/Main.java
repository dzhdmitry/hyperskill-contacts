import java.util.Scanner;

class Time {
    int hour;
    int minute;
    int second;

    public static Time noon() {
        return of(12, 0, 0);
    }

    public static Time midnight() {
        return of(0, 0, 0);
    }

    public static Time ofSeconds(long seconds) {
        long hours = 0;
        long minutes = 0;

        if (seconds > 59) {
            minutes = seconds / 60;
            seconds = seconds % 60;

            if (minutes > 59) {
                hours = minutes / 60;
                minutes = minutes % 60;

                if (hours > 23) {
                    hours = hours % 24;
                }
            }
        }

        return of((int) hours, (int) minutes, (int) seconds);
    }

    public static Time of(int hour, int minute, int second) {
        if (!(hour >= 0 && hour <= 23 && minute >= 0 && minute <= 59 && second >= 0 && second <= 59)) {
            return null;
        }

        Time time = new Time();

        time.hour = hour;
        time.minute = minute;
        time.second = second;

        return time;
    }
}

/* Do not change code below */
public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final String type = scanner.next();
        Time time = null;

        switch (type) {
            case "noon":
                time = Time.noon();
                break;
            case "midnight":
                time = Time.midnight();
                break;
            case "hms":
                int h = scanner.nextInt();
                int m = scanner.nextInt();
                int s = scanner.nextInt();
                time = Time.of(h, m, s);
                break;
            case "seconds":
                time = Time.ofSeconds(scanner.nextInt());
                break;
            default:
                time = null;
                break;
        }

        if (time == null) {
            System.out.println(time);
        } else {
            System.out.println(String.format("%s %s %s", time.hour, time.minute, time.second));
        }
    }
}