package org.learning.javawishlist;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class GiftList {
    public static void main(String[] args) {
        ArrayList<String> giftsList = new ArrayList<>();

        Scanner scan = new Scanner(System.in);

        loadListFromFile(giftsList);

        boolean choice = true;
        while (choice) {
            System.out.print("Insert gift: ");
            String gift = scan.nextLine();
            giftsList.add(gift);

            System.out.println("Length of the list: " + giftsList.size());
            System.out.print("Do you want to keep adding gifts? (Y/N): ");
            String answer = scan.nextLine();

            // equalsIgnoreCase confronta due stringhe ignorando le differenze tra maiuscole e minuscole.
            if (!answer.equalsIgnoreCase("Y")) {
                choice = false;
            }
        }

        // usiamo Collections.sort per ordinare una lista di oggetti in base all'ordine naturale degli elementi,
        // o secondo un comparatore specificato
        Collections.sort(giftsList);

        System.out.println("Ordered gift list:");
        for (String regalo : giftsList) {
            System.out.println(regalo);
        }

        saveListToFile(giftsList);
        readListFromFile();


        scan.close();
    }

    private static void loadListFromFile(ArrayList<String> giftsList) {
        try (Scanner fileReader = new Scanner(new File("gifts.txt"))) {
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                giftsList.add(line);
            }
        } catch (FileNotFoundException e) {
            // Se il file non esiste, non fa nulla in questo caso
        }
    }
    private static void saveListToFile(ArrayList<String> giftsList) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("gifts.txt"))) {
            for (String gift : giftsList) {
                writer.println(gift);
            }
        } catch (IOException e) {
            System.err.println("Error while saving the list to file: " + e.getMessage());
        }
    }
    private static void readListFromFile() {
        try (Scanner fileReader = new Scanner(new File("gifts.txt"))) {
            System.out.println("\nGifts read from file:");

            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
