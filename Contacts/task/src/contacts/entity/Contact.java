package contacts.entity;

import contacts.PhoneValidator;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.regex.Pattern;

abstract public class Contact implements Serializable {
    protected String phone;
    protected LocalDateTime createdAt;
    protected LocalDateTime updatedAt;

    public Contact() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public String getPhone() {
        return hasNumber() ? phone : "[no number]";
    }

    public boolean hasNumber() {
        return !phone.equals("");
    }

    @Override
    abstract public String toString();

    abstract public String getInfo();

    abstract public boolean matches(Pattern pattern);

    public static boolean isValidNumber(String phone) {
        PhoneValidator ph = new PhoneValidator(phone.split("[\\s-]", -1));

        return ph.isValidPhone();
    }
}
