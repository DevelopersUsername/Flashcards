import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> words = new HashSet<>();
        Set<String> text = new LinkedHashSet<>();

        int count = scanner.nextInt();
        for (int i = 0; i < count; i++) {
            words.add(scanner.next().toLowerCase());
        }

        count = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < count; i++) {
            text.addAll(Arrays.asList(scanner.nextLine().toLowerCase().split(" ")));
        }

        text.removeAll(words);
        text.forEach(System.out::println);
    }
}