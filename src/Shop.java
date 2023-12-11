import java.util.*;

public class Shop {
    private static final Scanner scan = new Scanner(System.in);
    public static List<Map<String, Object>> orders = new ArrayList<>();
    private static double payment;
    private static int totalPrice;

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
                Main.displayErrorMessage();
            }
        }
    }

    public static void displayMenu(){
        // Instantiate Objects for Scanner, MilkTea, and Coffee
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
                Main.displayErrorMessage();
            }
        }
    }

    public static void calculateTotal(){
        for (Map<String, Object> order : orders) {
            System.out.println(order);

            totalPrice += (int) order.get("subtotal");
        }
        try {
            System.out.print("Enter payment: ");
            payment = scan.nextDouble();

        }
        catch (InputMismatchException e){ // Display error message if there is an error
            Main.displayErrorMessage();
            calculateTotal();
        }
    }
}
