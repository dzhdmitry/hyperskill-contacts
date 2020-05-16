package contacts.command;

import contacts.App;
import contacts.entity.Contact;

public class RecordCommand implements CommandInterface {
    private Contact contact;

    public RecordCommand(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String getName() {
        return "record";
    }

    @Override
    public void execute(App app) {
        recordAction(app);
    }

    private void recordAction(App app) {
        app.io.println(contact.getInfo());
        app.io.println();

        switch (app.io.askString("[record] Enter action([edit, delete, menu]):")) {
            case "edit":
                app.executeCommand(new EditCommand(contact));

                break;
            case "delete":
                app.executeCommand(new DeleteCommand(contact));

                break;
            case "menu":
                app.executeCommand(new MenuCommand());

                break;
            default:
                app.io.println("Unknown action");
                app.io.println();
                recordAction(app);
        }
    }
}
