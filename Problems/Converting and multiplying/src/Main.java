import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int value;

        while (true) {
            String line = scanner.nextLine();

            try {
                value = Integer.parseInt(line);
                if (value == 0) {
                    break;
                }
                System.out.println(value * 10);
            } catch (Exception e) {
                System.out.println("Invalid user input: " + line);
            }
        }
    }
}