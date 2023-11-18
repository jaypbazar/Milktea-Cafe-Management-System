import java.util.*;

public class Shop {
    // displayWelcome method
    public static void displayWelcome(){
        Scanner scan = new Scanner(System.in); // Instantiate Scanner object

        while (true) { // Loop until user input is correct

            // Clear the console before printing anything
            Main.clearConsole();

            // Print the choices and command
            System.out.println(" ____________________________________________ ");
            System.out.println("|          Welcome to Paimon's Café          |");
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
                        System.out.println("\nInvalid choice! Please select a valid code.");
                        scan.nextLine();

                        System.out.println("\n\nPress enter to continue...");
                        scan.nextLine();
                }
                break; // break out of the loop if no errors ocurred
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

        Scanner scan = new Scanner(System.in); // Instantiate Scanner Object
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
            System.out.println("|      1     |           Milktea             |");
            System.out.println("|____________|_______________________________|");
            System.out.println("|      2     |            Coffee             |");
            System.out.println("|____________|_______________________________|");
            System.out.println("|      3     |       Back to Welcome         |");
            System.out.println("|____________|_______________________________|");

            try{ // Check for errors on user input
                System.out.print("\nEnter the code of your choice: ");
                int choice = scan.nextInt();

                switch (choice) {
                    case 1:
                        milktea.displayMilktea();
                        break;
                    case 2:
                        coffee.displayCoffee();
                        break;
                    case 3:
                        displayWelcome();
                        break;
                    default:
                        System.out.println("\nInvalid choice! Please select a valid code.");
                        scan.nextLine();

                        // Delay program until user press enter
                        System.out.println("\n\nPress enter to continue...");
                        scan.nextLine();

                        continue;
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
}
