package org.learning.javawishlist;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class GiftList {
    public static void main(String[] args) {
        ArrayList<String> giftsList = new ArrayList<>();

        Scanner scan = new Scanner(System.in);

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

        scan.close();
    }
}
