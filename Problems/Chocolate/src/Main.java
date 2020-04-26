import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int K = scanner.nextInt();

        System.out.println(N * M >= K && (K % N == 0 || K % M == 0) ? "YES" : "NO");
    }
}