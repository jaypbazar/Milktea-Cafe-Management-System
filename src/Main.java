import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Shop.displayWelcome();
    }

    // Remove all the text in the console
    public static void clearConsole(){
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Error clearing the console!");
        }
    }

    public static void displayErrorMessage(){
        Scanner scan = new Scanner(System.in);

        System.out.println("\nInvalid input! Please enter a valid input.");
        scan.nextLine(); // Absorb the invalid input

        // Delay program until user press enter
        System.out.println("\n\nPress enter to continue...");
        scan.nextLine();
    }
}
