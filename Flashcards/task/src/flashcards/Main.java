package flashcards;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input the number of cards:");
        String[] cards = new String[Integer.parseInt(scanner.nextLine())];
        String[] definitions = new String[cards.length];
        int currentNumber;

        for (int i = 0; i < cards.length; i++) {
            currentNumber = i +  1;
            System.out.println("The card #" + currentNumber + ":");
            cards[i] = scanner.nextLine();
            System.out.println("The definition of the card #" + currentNumber + ":");
            definitions[i] = scanner.nextLine();
        }

        for (int i = 0; i < cards.length; i++) {
            System.out.println("Print the definition of \"" + cards[i] + "\"");
            if (scanner.nextLine().equals(definitions[i])) {
                System.out.println("Correct answer.");
            } else {
                System.out.println("Wrong answer. The correct one is \"" + definitions[i] + "\"");
            }
        }
    }
}