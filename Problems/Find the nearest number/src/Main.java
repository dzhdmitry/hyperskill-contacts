import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> in = readArrayList(scanner);
        ArrayList<Integer> out = new ArrayList<>();
        StringBuilder outS = new StringBuilder();
        Integer number = scanner.nextInt();
        int lastDiff = -1;

        for (Integer n : in) {
            int currentDiff = Math.abs(n - number);

            if (lastDiff == -1) {
                out.add(n);

                lastDiff = currentDiff;
            } else {
                if (currentDiff < lastDiff) {
                    out.clear();
                    out.add(n);

                    lastDiff = currentDiff;
                } else if (currentDiff == lastDiff) {
                    out.add(n);
                }
            }
        }

        Collections.sort(out);

        for (int i=0; i<out.size(); i++) {
            outS.append(out.get(i));

            if (i != out.size() - 1) {
                outS.append(" ");
            }
        }

        System.out.println(outS.toString());
    }

    private static ArrayList<Integer> readArrayList(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}