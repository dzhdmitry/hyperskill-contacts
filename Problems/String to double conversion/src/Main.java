/**
 * It returns a double value or 0 if an exception occurred
 */
public static double convertStringToDouble(String input) {
    double result = 0;
    
    if (input == null) {
        return result;
    }

    try {
        result = Double.parseDouble(input);
    } catch (NumberFormatException e) {
        //
    }
    
    return result;
}
