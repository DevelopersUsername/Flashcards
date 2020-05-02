import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SortedMap<Integer, String> map = new TreeMap<>();

        int fromKey = scanner.nextInt();
        int toKey = scanner.nextInt();
        int count = scanner.nextInt();

        scanner.nextLine();
        for (int i = 0; i < count; i++) {
            map.put(scanner.nextInt(), scanner.next());
        }
        map.subMap(fromKey, ++toKey).forEach((key, value) -> System.out.println(key + " " + value));
    }
}