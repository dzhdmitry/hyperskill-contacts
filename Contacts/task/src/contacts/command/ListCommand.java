package contacts.command;

import contacts.App;
import contacts.entity.Contact;

public class ListCommand implements CommandInterface {
    @Override
    public String getName() {
        return "list";
    }

    @Override
    public void execute(App app) {
        for (int i=0; i<app.getContactsSize(); i++) {
            int number = i + 1;

            app.io.println(number + ". " + app.getContact(i).toString());
        }

        app.io.println();

        if (app.getContactsSize() == 0) {
            app.executeCommand(new MenuCommand());

            return;
        }

        String action = app.io.askString("[list] Enter action ([number], back):");

        switch (action) {
            case "back":
                app.executeCommand(new MenuCommand());

                break;
            default:
                int number = Integer.parseInt(action);
                Contact contact = app.getContact(number - 1);

                app.executeCommand(new RecordCommand(contact));
        }
    }
}
