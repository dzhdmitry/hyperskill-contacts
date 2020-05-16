package contacts.command;

import contacts.App;

public class CountCommand implements CommandInterface {
    @Override
    public String getName() {
        return "count";
    }

    @Override
    public void execute(App app) {
        app.io.println("The Phone Book has " + app.getContactsSize() + " records.");
        app.io.println();

        app.executeCommand(new MenuCommand());
    }
}
