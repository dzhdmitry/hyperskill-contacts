package contacts.command;

import contacts.App;
import contacts.entity.Contact;

import java.util.ArrayList;

public class SearchCommand implements CommandInterface {
    @Override
    public String getName() {
        return "search";
    }

    @Override
    public void execute(App app) {
        String searchQuery = app.io.askString("Enter search query:");
        ArrayList<Contact> results = app.searchContacts(searchQuery);
        String s = results.size() == 1 ? "" : "s";

        app.io.println("Found " + results.size() + " result" + s);

        for (int i=0; i<results.size(); i++) {
            int number = i + 1;

            app.io.println(number + ". " + results.get(i).toString());
        }

        String action = app.io.askString("[search] Enter action ([number], back, again):");

        switch (action) {
            case "back":
                app.executeCommand(new MenuCommand());

                break;
            case "again":
                app.executeCommand(new SearchCommand());

                break;
            default:
                int number = Integer.parseInt(action);
                Contact contact = app.getContact(number - 1);

                app.executeCommand(new RecordCommand(contact));
        }
    }
}
