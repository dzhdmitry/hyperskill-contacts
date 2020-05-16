package contacts.entity;

import contacts.fieldFactory.OrganizationFieldsFactory;

import java.time.LocalDateTime;
import java.util.regex.Pattern;

public class Organization extends Contact {
    private static final long serialVersionUID = 1L;

    private String organizationName;
    private String address;

    public Organization(OrganizationFieldsFactory factory) {
        super();

        this.organizationName = factory.createOrganizationName();
        this.address = factory.createAddress();
        this.phone = factory.createPhone();
    }

    public void save(OrganizationFieldsFactory factory) {
        switch (factory.askField()) {
            case "name":
                organizationName = factory.createOrganizationName();

                break;
            case "address":
                address = factory.createAddress();

                break;
            case "number":
                phone = factory.createPhone();

                break;
            default:
                System.out.println("Unknown field");

                return;
        }

        this.updatedAt = LocalDateTime.now();

        return;
    }

    @Override
    public String getInfo() {
        return "Organization name: " + organizationName + "\n" +
                "Address: " + address + "\n" +
                "Number: " + getPhone() + "\n" +
                "Time created: " + createdAt + "\n" +
                "Time last edit: " + updatedAt;
    }

    @Override
    public boolean matches(Pattern pattern) {
        String content = organizationName + address + phone;

        return pattern.matcher(content).find();
    }

    @Override
    public String toString() {
        return organizationName;
    }
}
