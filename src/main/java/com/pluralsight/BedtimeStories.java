package com.pluralsight;
import java.io.*;
import java.util.Scanner;

public class BedtimeStories {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome! What story would you like to hear for bed? \n" + //    Display menu
                "1. Goldilocks and the Three Bears \n" +
                "2. Hansel and Gretel \n" +
                "3. Mary had a little lamb");
//      Utilize if, else-if and else statements for user choices.
        int userChoice;
        String filePath;
        String storyTitle;

        while (true) { // Sets condition for Exit
            userChoice = input.nextInt();
            if (userChoice == 1) {
                filePath = "src/main/resources/goldilocks.txt";
                storyTitle = "Goldilocks and the Three Bears";
                break;
            } else if (userChoice == 2) {
                filePath = "src/main/resources/hansel_and_gretel.txt";
                storyTitle = "Hansel and Gretel";
                break;
            } else if (userChoice == 3) {
                filePath = "src/main/resources/mary_had_a_little_lamb.txt";
                storyTitle = "Mary had a little lamb";
                break;
                } else {
                System.out.println("Invalid Response. Please enter a valid choice: \n" +
                        "1. Goldilocks and the Three Bears \n" +
                        "2. Hansel and Gretel \n" +
                        "3. Mary had a little lamb");

                }
        }
        try { // Exception Handling (Try and Catch)
            FileInputStream fis = new FileInputStream(filePath);
            Scanner story = new Scanner(fis);
            System.out.println("Great Choice! Will begin reading: " + storyTitle);
            int lineNumber = 1;

            while (story.hasNextLine()) {
                String line = story.nextLine();
                System.out.println(lineNumber + ". " + line);
                lineNumber++;
            }

            fis.close(); // Close F.I.S.
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Goodnight! Have lovely dreams..."); // Exit message
        input.close();
    }

}
