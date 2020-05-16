/* Please, do not rename it */
class Problem {

    public static void main(String[] args) {
        String operator = args[0];

        switch (operator) {
            case "MAX":
                int max = Integer.parseInt(args[1]);

                for (int i=1; i<args.length; i++) {
                    int current = Integer.parseInt(args[i]);

                    if (current > max) {
                        max = current;
                    }
                }

                System.out.println(max);

                break;
            case "MIN":
                int min = Integer.parseInt(args[1]);

                for (int i=1; i<args.length; i++) {
                    int current = Integer.parseInt(args[i]);

                    if (current < min) {
                        min = current;
                    }
                }

                System.out.println(min);

                break;
            case "SUM":
                int sum = 0;

                for (int i=1; i<args.length; i++) {
                    int current = Integer.parseInt(args[i]);

                    sum += current;
                }

                System.out.println(sum);

                break;
            default:
                //
        }
    }
}