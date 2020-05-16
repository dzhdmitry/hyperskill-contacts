package contacts.entity;

import contacts.fieldFactory.PersonFieldsFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.regex.Pattern;

public class Person extends Contact {
    private static final long serialVersionUID = 1L;

    private String name;
    private String surname;
    private LocalDate birthDate;
    private String gender;

    public Person(PersonFieldsFactory factory) {
        super();

        this.name = factory.createName();
        this.surname = factory.createSurname();
        this.birthDate = factory.createBirthDate();
        this.gender = factory.createGender();
        this.phone = factory.createPhone();
    }

    public String getBirthDate() {
        return birthDate == null ? "[no data]" : birthDate.toString();
    }

    public String getGender() {
        return gender.equals("") ? "[no data]" : gender;
    }

    public void save(PersonFieldsFactory factory) {
        switch (factory.askField()) {
            case "name":
                name = factory.createName();

                break;
            case "surname":
                surname = factory.createSurname();

                break;
            case "number":
                phone = factory.createPhone();

                break;
            case "birth":
                birthDate = factory.createBirthDate();

                break;
            case "gender":
                gender = factory.createGender();

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
        return "Name: " + name + "\n" +
                "Surname: " + surname + "\n" +
                "Birth date: " + getBirthDate() + "\n" +
                "Gender: " + getGender() + "\n" +
                "Number: " + getPhone() + "\n" +
                "Time created: " + createdAt + "\n" +
                "Time last edit: " + updatedAt;
    }

    @Override
    public boolean matches(Pattern pattern) {
        String content = name + surname + phone;

        return pattern.matcher(content).find();
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }

    public static boolean isValidBirthDate(LocalDate birthDate) {
        return birthDate != null;
    }

    public static boolean isValidGender(String gender) {
        return gender.equals("M") || gender.equals("F");
    }
}
