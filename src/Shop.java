import java.util.*;

public class Shop {

    public static List<Map<String, Object>> orders = new ArrayList<>();

    // displayWelcome method
    public static void displayWelcome(){
        Scanner scan = new Scanner(System.in); // Instantiate Scanner object

        while (true) { // Loop until user input is correct

            // Clear the console before printing anything
            Main.clearConsole();

            // Print the choices and command
            System.out.println(" ____________________________________________ ");
            System.out.println("|          Welcome to Paimon's Caf\u00e9          |");
            System.out.println("|____________________________________________|");
            System.out.println("|    Code    |            Command            |");
            System.out.println("|____________|_______________________________|");
            System.out.println("|      1     |         Make an order         |");
            System.out.println("|____________|_______________________________|");
            System.out.println("|      2     |             Exit              |");
            System.out.println("|____________|_______________________________|");

            try{ // Check for errors on user input
                System.out.print("\nEnter the code of your choice: ");
                int choice = scan.nextInt();

                switch (choice) {
                    case 1:
                        displayMenu();
                        break;
                    case 2:
                        System.out.println("\nThank you! Please come again.");
                        break;
                    default:
                        throw new InputMismatchException();
                }
                break; // break out of the loop if no errors occurred
            }
            catch(InputMismatchException e){ // Display error message if there is an error
                System.out.println("\nInvalid input! Please enter a valid input.");
                scan.nextLine(); // Absorb the invalid input

                // Delay program until user press enter
                System.out.println("\n\nPress enter to continue...");
                scan.nextLine();
            }
        }
    }

    public static void displayMenu(){
        // Instantiate Objects for Scanner, MilkTea, and Coffee
        Scanner scan = new Scanner(System.in);
        MilkTea milktea = new MilkTea();
        Coffee coffee = new Coffee();

        while(true){
            // Clear the console before printing anything
            Main.clearConsole();

            // Print the choices and command
            System.out.println(" ____________________________________________ ");
            System.out.println("|                     MENU                   |");
            System.out.println("|____________________________________________|");
            System.out.println("|    Code    |           Products            |");
            System.out.println("|____________|_______________________________|");
            System.out.println("|      1     |           MilkTea             |");
            System.out.println("|____________|_______________________________|");
            System.out.println("|      2     |            Coffee             |");
            System.out.println("|____________|_______________________________|");
            System.out.println("|      3     |         Cancel Order          |");
            System.out.println("|____________|_______________________________|");

            try{ // Check for errors on user input
                System.out.print("\nEnter the code of your choice: ");
                int choice = scan.nextInt();

                // Execute method according to user choice
                switch (choice) {
                    case 1:
                        milktea.displayProduct();
                        break;
                    case 2:
                        coffee.displayProduct();
                        break;
                    case 3:
                        displayWelcome();
                        break;
                    default:
                        throw new InputMismatchException();
                }
                break; // break out of the loop if no errors occurred
            }
            catch(InputMismatchException e){ // Display error message if there is an error
                System.out.println("\nInvalid input! Please enter a valid input.");
                scan.nextLine(); // Absorb the invalid input

                // Delay program until user press enter
                System.out.println("\n\nPress enter to continue...");
                scan.nextLine();
            }
        }
    }

    public static void calculateTotal(){

    }
}
