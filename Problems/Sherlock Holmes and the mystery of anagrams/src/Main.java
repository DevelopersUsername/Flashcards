import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Character, Integer> firstWord = new HashMap<>();
        Map<Character, Integer> secondWord = new HashMap<>();

        fillMap(scanner, firstWord);
        fillMap(scanner, secondWord);
        System.out.println(Objects.equals(firstWord, secondWord) ? "yes" : "no");
    }
    static void fillMap(Scanner scanner, Map<Character, Integer> map) {
        for (char c : scanner.next().toLowerCase().toCharArray()) {
            int currentValue = map.getOrDefault(c, 0);
            map.put(c, ++currentValue);
        }
    }
}