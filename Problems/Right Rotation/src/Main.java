import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split("\\s");
        int t = scanner.nextInt() % line.length;

        for (int i=0; i<t; i++) {
            line = rotate(line);
        }

        StringBuilder sb = new StringBuilder();

        for (String ch : line) {
            sb.append(" ").append(ch);
        }

        System.out.println(sb.toString());
    }

    private static String[] rotate(String[] numbers) {
        StringBuilder sb = new StringBuilder();

        sb.append(numbers[numbers.length - 1]);

        for (int i=0; i<numbers.length-1; i++) {
            sb.append(" ").append(numbers[i]);
        }

        return sb.toString().split("\\s");
    }
}
