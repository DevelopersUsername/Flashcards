import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        String pathToFile = "./Problems/World population/dataset_91069.txt";
        File file = new File(pathToFile);

        int year = 0;
        int currentYear = 0;
        int increasePopulation = 0;
        long populationCurrentYear = 0L;
        long populationPreviousYear = 0L;

        try (Scanner scanner = new Scanner(file)) {

            // First year
            if (scanner.hasNext()) {
                // Header
                scanner.nextLine();

                year = scanner.nextInt();
                populationPreviousYear = scanner.nextLong();
            }

            while (scanner.hasNext()) {
                currentYear = scanner.nextInt();
                populationCurrentYear = scanner.nextLong();
                if (populationCurrentYear - populationPreviousYear > increasePopulation) {
                    increasePopulation = (int) (populationCurrentYear - populationPreviousYear);
                    year = currentYear;
                }
                populationPreviousYear = populationCurrentYear;
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + pathToFile);
        }
        System.out.println(year);
    }
}