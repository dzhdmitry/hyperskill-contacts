package contacts;

import java.util.regex.Pattern;

public class PhoneValidator {
    private String[] parts;
    private boolean parenthesisPartFound;
    private Pattern patternFirstPart;
    private Pattern patternFirstParenthesisPart;
    private Pattern patternRegularPart;
    private Pattern patternRegularParenthesisPart;

    public PhoneValidator(String[] parts) {
        this.parts = parts;
        this.parenthesisPartFound = false;
        this.patternFirstPart = Pattern.compile("\\+?[A-Za-z0-9]+");
        this.patternFirstParenthesisPart = Pattern.compile("\\+?\\([A-Za-z0-9]+\\)");
        this.patternRegularPart = Pattern.compile("[A-Za-z0-9]{2,}");
        this.patternRegularParenthesisPart = Pattern.compile("\\([A-Za-z0-9]{2,}\\)");
    }

    public boolean isValidPhone() {
        for (int i=0; i<parts.length; i++) {
            boolean partIsValid;

            if (i == 0) {
                partIsValid = firstPart(parts[i]);
            } else if (i == 1) {
                partIsValid = secondPart(parts[i]);
            } else {
                partIsValid = otherPart(parts[i]);
            }

            if (!partIsValid) {
                return false;
            }
        }

        return true;
    }

    private boolean firstPart(String part) {
        if (patternFirstParenthesisPart.matcher(part).matches()) {
            parenthesisPartFound = true;

            return true;
        }

        return patternFirstPart.matcher(part).matches();
    }

    private boolean secondPart(String part) {
        if (patternRegularParenthesisPart.matcher(part).matches()) {
            if (parenthesisPartFound) {
                return false;
            } else {
                parenthesisPartFound = true;

                return true;
            }
        }

        return patternRegularPart.matcher(part).matches();
    }

    private boolean otherPart(String part) {
        return patternRegularPart.matcher(part).matches();
    }
}
