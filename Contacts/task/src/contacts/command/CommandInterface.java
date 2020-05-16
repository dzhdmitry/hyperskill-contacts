package contacts.command;

import contacts.App;

public interface CommandInterface {
    String getName();
    void execute(App app);
}
