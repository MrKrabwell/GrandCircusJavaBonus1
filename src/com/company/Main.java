package com.company;

import java.util.Scanner;

public class Main {

    /*
    This is the method to get user's numerical grade
     */
    public static int GetUserNumGrade() {
        // Variable declarations
        int userNumGrade = 0;                  // user's numerical grade
        Scanner scan = new Scanner(System.in); // Scanner object for user input

        // Prompt user to enter numerical grade
        System.out.print("Enter a numerical grade: ");
        userNumGrade = scan.nextInt();

        // Return user input length
        return userNumGrade;
    }

    /*
    This is the method to get user's numerical grade
    */
    public static char FindLetterGrade(int numericalGrade) {
        // Variable declarations
        char userLetterGrade = 'X';                  // user's letter grade

        // Find out letter grade
        if ((numericalGrade <= 100) && (numericalGrade >= 88)) {
            userLetterGrade = 'A';
        }
        else if (numericalGrade >= 80) {
            userLetterGrade = 'B';
        }
        else if (numericalGrade >= 67) {
            userLetterGrade = 'C';
        }
        else if (numericalGrade >= 60) {
            userLetterGrade = 'D';
        }
        else if (numericalGrade >= 0) {
            userLetterGrade = 'F';
        }
        else {
            // do something to validate?
        }

        // Return user input length
        return userLetterGrade;
    }

    /*
    This method will ask whether the user wants to continue to program or not
    */
    public static boolean GetUserProgContinue() {
        // Variable declarations
        boolean progContinue = true;            // Boolean to determine whether user wants to continue
        boolean validChar = false;              // Boolean to determine whether user input was valid
        String userInput = "";                  // String to store user input.
        char progContinueChar = 'y';            // Character input of user
        Scanner scan = new Scanner(System.in);  // Scanner object for user input

        while (validChar == false) {
            // Prompt user if they want to continue
            System.out.print("Continue? (y/n): ");
            userInput = scan.next();                // read user input
            progContinueChar = userInput.charAt(0); // progContinueChar is first letter in userInput string

            // If user input is not a single character, then ask user again
            if (userInput.length() != 1) {
                System.out.println("That is not a valid input.  Please try again.");
                validChar = false;
            }
            // If user input is not y, Y, n, or N, then ask user again
            else if ((progContinueChar != 'y') && (progContinueChar != 'Y') &&
                    (progContinueChar != 'n') && (progContinueChar != 'N')) {
                System.out.println("That is not a valid input.  Please try again.");
                validChar = false;
            }
            else {
                validChar = true;
            }
        }

        // Depending on user input, set progContinue to true or false
        if (progContinueChar == 'y' || progContinueChar == 'Y') {
            progContinue = true;
        }
        else if (progContinueChar == 'n' || progContinueChar == 'N') {
            progContinue = false;
        }
        else {
            // Should never reach here
            progContinue = true;
        }

        // Return result of whether user wants to continue or not
        return progContinue;
    }

    /*
    This is the main program
     */
    public static void main(String[] args) {
        // Variable declarations
        int userNumGrade = 0;           // user's numerical grade
        char userLetterGrade = 'X';      // user's letter grade
        boolean programContinue = true; // user's decision to continue program

        // Welcome message
        System.out.println("Welcome to the Letter Grade Converter!");
        System.out.println("");

        // While loop to keep program running until user wants to quit
        while (programContinue == true) {

            // Get user's numerical grade
            userNumGrade = GetUserNumGrade();

            // Find user's letter grade using numerical grade and print results
            userLetterGrade = FindLetterGrade(userNumGrade);
            System.out.println("Letter Grade: " + userLetterGrade);

            // Ask the user if they want to continue
            programContinue = GetUserProgContinue();
        }

    }
}
