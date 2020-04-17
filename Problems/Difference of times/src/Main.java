import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = new int[6];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        int startDate = array[0] * 3600 + array[1] * 60 + array[2];
        int endDate = array[3] * 3600 + array[4] * 60 + array[5];

        System.out.println(endDate - startDate);
    }
}