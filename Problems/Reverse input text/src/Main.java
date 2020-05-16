import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

class Main {
    public static void main(String[] args) throws Exception {
        try (Reader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();
            int charAsNumber = reader.read();

            while (charAsNumber != -1) {
                sb.append((char) charAsNumber);

                charAsNumber = reader.read();
            }

            System.out.println(sb.reverse().toString());
        }
    }
}