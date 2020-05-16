import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

class Main {
    public static void main(String[] args) throws Exception {
        try (Reader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int charAsInt = reader.read();
            boolean lastWasSpace = true;
            int amount = 0;

            while (charAsInt != -1) {
                if ((char) charAsInt == ' ') {
                    lastWasSpace = true;
                } else {
                    if (lastWasSpace) {
                        amount++;
                    }

                    lastWasSpace = false;
                }

                charAsInt = reader.read();
            }

            System.out.println(amount);
        }
    }
}