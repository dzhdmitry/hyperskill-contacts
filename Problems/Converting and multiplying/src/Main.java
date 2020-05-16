import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while (true) {
            String line = scanner.nextLine();

            if (line.equals("0")) {
                break;
            }

            try {
                int number = Integer.parseInt(line);

                sb.append(number * 10);
            } catch (NumberFormatException e) {
                sb.append("Invalid user input: ").append(line);
            }

            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}