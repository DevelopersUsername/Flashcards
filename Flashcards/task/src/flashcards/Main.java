package flashcards;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {

        Flashcards flashcards;
        if (args.length > 0)
            flashcards = new Flashcards(args);
        else
            flashcards = new Flashcards();

        while (true) {
            flashcards.outputMsg("Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):");
            switch (flashcards.inputMsg()) {
                case "add":
                    flashcards.add();
                    break;
                case "remove":
                    flashcards.remove();
                    break;
                case "import":
                    flashcards.importCards();
                    break;
                case "export":
                    flashcards.exportCards();
                    break;
                case "ask":
                    flashcards.ask();
                    break;
                case "exit":
                    flashcards.exit();
                    return;
                case "log":
                    flashcards.log();
                    break;
                case "hardest card":
                    flashcards.hardestCard();
                    break;
                case "reset stats":
                    flashcards.resetStats();
                    break;
                default:
                    flashcards.outputMsg("Action not found!");
            }
        }
    }
}

class Flashcards {
    Scanner scanner;
    String importFile = "", exportFile = "";
    Map<String, String> mapCards;
    Map<String, Integer> cardsStat;
    ArrayList<String> log;

    public Flashcards() {
        this.scanner = new Scanner(System.in);
        this.mapCards = new LinkedHashMap<>();
        this.cardsStat = new LinkedHashMap<>();
        this.log = new ArrayList<>();
    }

    public Flashcards(String[] args) {

        this();

        for (int i = 0; i < args.length; i++) {
            if ("-import".equals(args[i]))
                this.importFile = args[i + 1];
            else if ("-export".equals(args[i]))
                this.exportFile = args[i + 1];
        }
        if (!importFile.isEmpty())
            importCards(importFile);
    }

    void add() {
        outputMsg("The card:");

        String currentCard = inputMsg();
        if (mapCards.containsKey((currentCard))) {
            outputMsg("The card \"" + currentCard + "\" already exists.");
            return;
        }

        outputMsg("The definition of the card:");
        String currentDefinition = inputMsg();
        if (mapCards.containsValue(currentDefinition)) {
            outputMsg("The definition \"" + currentDefinition + "\" already exists.");
            return;
        }

        mapCards.put(currentCard, currentDefinition);
        outputMsg("The pair (\"" + currentCard + "\":\"" + currentDefinition + "\") has been added.");
    }

    void remove() {
        outputMsg("The card:");

        String currentCard = inputMsg();
        if (!mapCards.containsKey((currentCard))) {
            outputMsg("Can't remove \"" + currentCard + "\": there is no such card.");
            return;
        }

        mapCards.remove(currentCard);
        cardsStat.remove(currentCard);
        outputMsg("The card has been removed.");
    }

    void importCards() {
        outputMsg("File name:");
        importCards(inputMsg());
    }

    void importCards(String importFile) {

        int count = 0;
        File file = new File(importFile);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String card = scanner.nextLine();
                String definition = scanner.nextLine();
                Integer stat = Integer.parseInt(scanner.nextLine());

                mapCards.put(card, definition);
                cardsStat.put(card, stat);
                count++;
            }

            outputMsg(count + " cards have been loaded.");
        } catch (FileNotFoundException e) {
            outputMsg("File not found.");
        }
    }

    void exportCards() {
        outputMsg("File name:");
        exportCards(inputMsg());
    }

    void exportCards(String exportFile) {

        AtomicInteger count = new AtomicInteger();
        File file = new File(exportFile);

        try (PrintWriter printWriter = new PrintWriter(file)){
            mapCards.forEach((key, value) -> {
                printWriter.println(key + System.lineSeparator() + value
                        + System.lineSeparator() + cardsStat.getOrDefault(key, 0));
                count.getAndIncrement();
            });

            outputMsg(count + " cards have been saved.");
        } catch (IOException e) {
            outputMsg("File not found.");
        }
    }

    void ask() {

        Random random = new Random();
        ArrayList<String> arrayKeys = new ArrayList<>(mapCards.keySet());
        String currentAnswer;
        String randomKey;

        outputMsg("How many times to ask?");
        int count = Integer.parseInt(inputMsg());

        for (int i = 0; i < count; i++) {

            randomKey = arrayKeys.get(random.nextInt(arrayKeys.size()));

            outputMsg("Print the definition of \"" + randomKey + "\":");
            currentAnswer = inputMsg();
            if (currentAnswer.equals(mapCards.get(randomKey))) {
                outputMsg("Correct answer");

                return;
            } else if (mapCards.containsValue(currentAnswer)){
                outputMsg("Wrong answer. The correct one is \"" + mapCards.get(randomKey)
                        + "\", you've just written the definition of \"" + getKeyByValue(mapCards, currentAnswer) + "\".");
            } else {
                outputMsg("Wrong answer. The correct one is \"" + mapCards.get(randomKey) + "\".");
            }

            if (cardsStat.containsKey(randomKey))
                cardsStat.put(randomKey, cardsStat.get(randomKey) + 1);
            else
                cardsStat.put(randomKey, 1);
        }
    }

    void log() {

        outputMsg("File name:");
        File file = new File(inputMsg());

        try (PrintWriter printWriter = new PrintWriter(file)){
            log.forEach(printWriter::println);
            outputMsg("The log has been saved.");
        } catch (IOException e) {
            outputMsg("File not found.");
        }
    }

    void hardestCard() {

        if (cardsStat.size() == 0) {
            outputMsg("There are no cards with errors.");
            return;
        }

        int maxError = 0;
        for (Map.Entry<String , Integer> entry : cardsStat.entrySet()) {
            if (entry.getValue() > maxError)
                maxError = entry.getValue();
        }

        StringBuilder textMsg = new StringBuilder();
        boolean firstCard = true;

        for (Map.Entry<String , Integer> entry : cardsStat.entrySet()) {
            if (entry.getValue() == maxError) {
                if (firstCard) {
                    firstCard = false;
                    textMsg.append("\"").append(entry.getKey()).append("\"");
                } else {
                    textMsg.append(", \"").append(entry.getKey()).append("\"");
                }
            }
        }

        outputMsg("The hardest card is " + textMsg + ". You have " + maxError + " errors answering it.");
    }

    void resetStats() {
        cardsStat.clear();
        outputMsg("Card statistics has been reset.");
    }

    void exit() {
        outputMsg("Bye bye!");
        if (!exportFile.isEmpty())
            exportCards(exportFile);
    }

    void outputMsg(String msg) {
        System.out.println(msg);
        log.add(msg);
    }

    String inputMsg() {
        String msg = scanner.nextLine();
        log.add(msg);

        return msg;
    }

    private <T, E> T getKeyByValue(Map<T, E> map, E value) {
        for (Map.Entry<T, E> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
}