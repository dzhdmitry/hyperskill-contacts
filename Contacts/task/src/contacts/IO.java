package contacts;

import java.util.Scanner;

public class IO {
    private final Scanner scanner;

    public IO(Scanner scanner) {
        this.scanner = scanner;
    }

    public String askString(String question) {
        println(question);

        return scanner.nextLine();
    }

    public void println(String content) {
        System.out.println(content);
    }

    public void println() {
        System.out.println();
    }
}
