import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Container container = new Container(line.split(" "));

        System.out.println(container.get());
    }
}

class Container {
    private LocalDateTime dateTime;
    private int daysToAdd;
    private int hoursToSubtract;

    public Container(String[] parts) {
        for (int i=0; i<parts.length; i++) {
            if (i == 0) {
                this.dateTime = LocalDateTime.parse(parts[i]);
            } else if (i == 1) {
                this.daysToAdd = Integer.parseInt(parts[i]);
            } else {
                this.hoursToSubtract = Integer.parseInt(parts[i]);
            }
        }
    }

    public LocalDateTime get() {
        return dateTime.plusDays(daysToAdd).minusHours(hoursToSubtract);
    }
}

