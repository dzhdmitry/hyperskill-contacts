package contacts.command;

import contacts.App;
import contacts.entity.Contact;

public class DeleteCommand implements CommandInterface {
    private Contact contact;

    public DeleteCommand(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String getName() {
        return "delete";
    }

    @Override
    public void execute(App app) {
        app.deleteContact(contact);
        app.io.println("The record removed!");
        app.io.println();
        app.executeCommand(new MenuCommand());
    }
}
