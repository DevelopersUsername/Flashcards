// Posted from EduTools plugin
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = new int[scanner.nextInt()];
        int maxTax = -1;
        int numCompany = 0;

        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }

        for (int i = 0; i < array.length; i++) {
            int taxes = (array[i] * scanner.nextInt());
            if (taxes > maxTax) {
                maxTax = taxes;
                numCompany = i + 1;
            }
        }
        System.out.println(numCompany);
    }
}