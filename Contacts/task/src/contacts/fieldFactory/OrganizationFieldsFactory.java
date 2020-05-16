package contacts.fieldFactory;

import contacts.IO;

public class OrganizationFieldsFactory extends ContactFieldsFactory {
    public OrganizationFieldsFactory(IO io) {
        super(io);
    }

    public String createOrganizationName() {
        return io.askString("Enter the organization name:");
    }

    public String createAddress() {
        return io.askString("Enter the address:");
    }

    public String askField() {
        return io.askString("Select a field (name, address, number):");
    }
}
