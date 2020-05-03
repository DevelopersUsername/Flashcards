package flashcards;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> mapCards = new LinkedHashMap<>();
        String currentCard;
        String currentDefinition;
        String currentAnswer;
        int currentNumber;
        
        System.out.println("Input the number of cards:");
        int countCards = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < countCards; i++) {

            currentNumber = i + 1;
            System.out.println("The card #" + currentNumber + ":");
            
            currentCard = scanner.nextLine();
            while (mapCards.containsValue((currentCard.toLowerCase()))) {
                System.out.println("The card \"" + currentCard + "\" already exists. Try again:");
                currentCard = scanner.nextLine();
            }

            System.out.println("The definition of the card #" + currentNumber + ":");
            currentDefinition = scanner.nextLine();
            while (mapCards.containsKey(currentDefinition.toLowerCase())) {
                System.out.println("The definition \"" + currentDefinition + "\" already exists. Try again:");
                currentDefinition = scanner.nextLine();
            }

            mapCards.put(currentDefinition, currentCard);
        }

        for (Map.Entry<String, String> entry: mapCards.entrySet()) {
            System.out.println("Print the definition of \"" + entry.getValue() + "\"");
            currentAnswer = scanner.nextLine();
            if (currentAnswer.equals(entry.getKey())) {
                System.out.println("Correct answer.");
            } else {
                if (mapCards.containsKey(currentAnswer)) {
                    System.out.println("Wrong answer. The correct one is \"" + entry.getKey() + "\", " +
                            "you've just written the definition of \"" + mapCards.get(currentAnswer) + "\"");
                } else {
                    System.out.println("Wrong answer. The correct one is \"" + entry.getKey() + "\"");
                }
            }
        }
    }
}