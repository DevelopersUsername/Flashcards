import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int seed = 0;
        int min = K;
        int value;

        for (int i = A; i <= B; i++) {
            Random random = new Random(i);
            int max = 0;

            for (int j = 0; j < N; j++) {
                value = random.nextInt(K);
                if (value > max)
                    max = value;
            }
            if (max < min) {
                seed = i;
                min = max;
            }
        }
        System.out.println(seed);
        System.out.println(min);
    }
}