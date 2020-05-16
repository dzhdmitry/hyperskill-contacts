package contacts.fieldFactory;

import contacts.IO;
import contacts.entity.Person;

import java.time.LocalDate;

public class PersonFieldsFactory extends ContactFieldsFactory {
    public PersonFieldsFactory(IO io) {
        super(io);
    }

    public String createName() {
        return io.askString("Enter the name of the person:");
    }

    public String createSurname() {
        return io.askString("Enter the surname of the person:");
    }

    public LocalDate createBirthDate() {
        String birthDateRaw = io.askString("Enter the birth date:");

        if (birthDateRaw.equals("")) {
            io.println("Bad birth date!");

            return null;
        }

        LocalDate birthDate = LocalDate.parse(birthDateRaw);

        if (!Person.isValidBirthDate(birthDate)) {
            io.println("Bad birth date!");

            return null;
        }

        return birthDate;
    }

    public String createGender() {
        String gender = io.askString("Enter the gender (M, F):");

        if (!Person.isValidGender(gender)) {
            io.println("Bad gender!");

            return "";
        }

        return gender;
    }

    public String askField() {
        return io.askString("Select a field (name, surname, birth, gender, number):");
    }
}
