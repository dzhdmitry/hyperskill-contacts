package contacts.fieldFactory;

import contacts.IO;
import contacts.entity.Contact;

abstract public class ContactFieldsFactory {
    protected IO io;

    public ContactFieldsFactory(IO io) {
        this.io = io;
    }

    public String createPhone() {
        String phone = io.askString("Enter the number:");

        if (!Contact.isValidNumber(phone)) {
            io.println("Wrong number format!");

            return "";
        }

        return phone;
    }
}
