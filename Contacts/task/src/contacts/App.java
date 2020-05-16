package contacts;

import contacts.command.CommandInterface;
import contacts.command.MenuCommand;
import contacts.entity.Contact;
import contacts.entity.Organization;
import contacts.entity.Person;
import contacts.fieldFactory.OrganizationFieldsFactory;
import contacts.fieldFactory.PersonFieldsFactory;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class App {
    public IO io;
    private final ContactsStorage contactsStorage;
    private final ArrayList<Contact> contacts;

    public App(IO io, ContactsStorage contactsStorage) {
        this.io = io;
        this.contactsStorage = contactsStorage;
        this.contacts = new ArrayList<>();
    }

    public void start() {
        contacts.addAll(contactsStorage.getContacts());
        executeCommand(new MenuCommand());
    }

    public void executeCommand(CommandInterface command) {
        command.execute(this);
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        contactsStorage.putContacts(contacts);
    }

    public Contact getContact(int n) {
        return contacts.get(n);
    }

    public int getContactsSize() {
        return contacts.size();
    }

    public void saveContact(Contact contact) {
        if (contact.getClass() == Person.class) {
            PersonFieldsFactory factory = new PersonFieldsFactory(io);

            ((Person) contact).save(factory);
        } else if (contact.getClass() == Organization.class) {
            OrganizationFieldsFactory factory = new OrganizationFieldsFactory(io);

            ((Organization) contact).save(factory);
        }

        contactsStorage.putContacts(contacts);
    }

    public void deleteContact(Contact contact) {
        contacts.remove(contact);
        contactsStorage.putContacts(contacts);
    }

    public ArrayList<Contact> searchContacts(String query) {
        ArrayList<Contact> results = new ArrayList<>();
        Pattern pattern = Pattern.compile(query, Pattern.CASE_INSENSITIVE);

        for (Contact contact : contacts) {
            if (contact.matches(pattern)) {
                results.add(contact);
            }
        }

        return results;
    }
}
