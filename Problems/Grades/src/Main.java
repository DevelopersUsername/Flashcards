import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int D = 0;
        int C = 0;
        int B = 0;
        int A = 0;
        int count = scanner.nextInt();

        for (int i = 0; i < count; i++) {
            switch (scanner.nextInt()) {
                case 5:
                    A++;
                    break;
                case 4:
                    B++;
                    break;
                case 3:
                    C++;
                    break;
                case 2:
                    D++;
                    break;
            }
        }
        System.out.println(D + " " + C + " " + B + " " + A);
    }
}