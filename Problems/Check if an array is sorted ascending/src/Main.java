import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[scanner.nextInt()];

        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }

        boolean sorted = true;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i-1]){
                sorted = false;
            }
        }
        System.out.println(sorted);
    }
}