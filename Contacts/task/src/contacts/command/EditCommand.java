package contacts.command;

import contacts.App;
import contacts.entity.Contact;

public class EditCommand implements CommandInterface {
    private Contact contact;

    public EditCommand(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String getName() {
        return "edit";
    }

    @Override
    public void execute(App app) {
        app.saveContact(contact);
        app.io.println("Saved");
        app.executeCommand(new RecordCommand(contact));
    }
}
