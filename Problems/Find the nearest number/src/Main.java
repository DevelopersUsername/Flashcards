import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (String s : scanner.nextLine().split("\\s+")) {
            arrayList.add(Integer.parseInt(s));
        }

        int n = Integer.parseInt(scanner.nextLine());
        int numberUp = n;
        int numberDown = n;

        while (true) {
            if (arrayList.contains(numberUp) || arrayList.contains(numberDown))
                break;
            else {
                numberUp++;
                numberDown--;
            }
        }

        Collections.sort(arrayList);
        for (int elem : arrayList) {
            if (elem == numberUp || elem == numberDown)
                System.out.print(elem + " ");
        }
    }
}