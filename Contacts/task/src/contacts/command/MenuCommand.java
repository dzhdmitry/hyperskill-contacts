package contacts.command;

import contacts.App;

public class MenuCommand implements CommandInterface {
    @Override
    public String getName() {
        return "menu";
    }

    @Override
    public void execute(App app) {
        menuAction(app);
    }

    private void menuAction(App app) {
        switch (app.io.askString("[menu] Enter action (add, list, search, count, exit):")) {
            case "add":
                app.executeCommand(new AddCommand());

                break;
            case "list":
                app.executeCommand(new ListCommand());

                break;
            case "search":
                app.executeCommand(new SearchCommand());

                break;
            case "count":
                app.executeCommand(new CountCommand());

                break;
            case "exit":
                //

                break;
            default:
                app.io.println("Unknown action");
                app.io.println();
                menuAction(app);
        }
    }
}
