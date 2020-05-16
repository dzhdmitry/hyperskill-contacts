package contacts;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String fileName = getFilename(args);
        IO io = new IO(new Scanner(System.in));
        ContactsStorage contactsStorage = new ContactsStorage(fileName);
        App app = new App(io, contactsStorage);

        if (fileName != null) {
            io.println("open " + fileName);
            io.println();
        }

        app.start();
    }

    private static String getFilename(String[] args) {
        if (args.length < 1) {
            //return "/Users/dmitry/projects/contacts.db"; //null;
            return null;
        }

        return args[0];
    }
}
