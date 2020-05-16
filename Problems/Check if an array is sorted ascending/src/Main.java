import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        int prev = 0;

        for (int i=0; i<amount; i++) {
            int current = scanner.nextInt();

            if (current < prev) {
                System.out.println(false);

                return;
            }

            prev = current;
        }

        System.out.println(true);
    }
}
