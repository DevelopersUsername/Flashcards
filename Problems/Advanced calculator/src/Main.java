/* Please, do not rename it */
class Problem {

    public static void main(String args[]) {
        String operator = args[0];

        switch (operator) {
            case "MAX":
                MAX(args);
                break;
            case "MIN":
                MIN(args);
                break;
            case "SUM":
                SUM(args);
                break;
        }
    }
    static void MAX(String[] args) {
        int max = Integer.parseInt(args[1]);
        int value;

        for (int i = 2; i < args.length; i++) {
            value = Integer.parseInt(args[i]);
            if (value > max)
                max = value;
        }
        System.out.println(max);
    }

    static void MIN(String[] args) {
        int min = Integer.parseInt(args[1]);
        int value;

        for (int i = 2; i < args.length; i++) {
            value = Integer.parseInt(args[i]);
            if (value < min)
                min = value;
        }
        System.out.println(min);
    }

    static void SUM(String[] args) {
        int sum = 0;
        for (int i = 1; i < args.length; i++) {
            sum += Integer.parseInt(args[i]);
        }
        System.out.println(sum);
    }
}