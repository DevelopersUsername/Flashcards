// Posted from EduTools plugin
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] array = new int[scanner.nextInt()];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        boolean eachOther = false;

        for (int i = 1; i < array.length; i++) {
            if (array[i] == m && array[i-1] == n || array[i] == n && array[i-1] == m) {
                eachOther = true;
                break;
            }
        }
        System.out.println(eachOther);
    }
}