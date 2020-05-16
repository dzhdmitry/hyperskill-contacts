package contacts.command;

import contacts.App;
import contacts.entity.Contact;
import contacts.entity.Organization;
import contacts.entity.Person;
import contacts.fieldFactory.OrganizationFieldsFactory;
import contacts.fieldFactory.PersonFieldsFactory;

public class AddCommand implements CommandInterface {
    @Override
    public String getName() {
        return "add";
    }

    @Override
    public void execute(App app) {
        Contact contact;

        switch (app.io.askString("Enter the type (person, organization):")) {
            case "person":
                PersonFieldsFactory personFieldsFactory = new PersonFieldsFactory(app.io);
                contact = new Person(personFieldsFactory);

                break;
            case "organization":
                OrganizationFieldsFactory organizationFieldsFactory = new OrganizationFieldsFactory(app.io);
                contact = new Organization(organizationFieldsFactory);

                break;
            default:
                app.io.println("Unknown type");

                return;
        }

        app.addContact(contact);
        app.io.println("The record added.");
        app.io.println();

        app.executeCommand(new MenuCommand());
    }
}
