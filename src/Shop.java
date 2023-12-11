import java.util.*;

public class Shop {
    private static final Scanner sc = Main.scanner;
    public static List<Map<String, Object>> orders = new ArrayList<>();

    // displayWelcome method
    public static void displayWelcome(){
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
                int choice = sc.nextInt();

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
        // Instantiate Objects for MilkTea and Coffee
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
                int choice = sc.nextInt();

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
        Main.clearConsole();
        double totalPrice = 0;

        System.out.println("\t\tORDER DETAILS\n" +"\nProduct\t\t    Quantity\t\t  Price");
        for (Map<String, Object> order : orders) {
            if (order.containsKey("flavor")) {
                System.out.println(
                        order.get("size")+" "+order.get("flavor")+
                        "\t\t"+order.get("quantity")+
                        "\t\t"+String.format("Php %.2f", Double.parseDouble(order.get("subtotal").toString()))
                );
            }
            else {
                System.out.println(
                        order.get("coffee_type") +
                        "\t\t"+order.get("quantity") +
                        "\t\t"+String.format("Php %.2f", Double.parseDouble(order.get("subtotal").toString()))
                );
            }
            totalPrice += (int) order.get("subtotal");
        }

        System.out.printf("\nTotal Price: Php %.2f%n", totalPrice);

        try {
            System.out.print("\nEnter payment: ");
            double payment = sc.nextDouble();

            // If payment is less than total price, display error message and repeat
            if (payment < totalPrice) {
                System.out.println("\nInsufficient Payment!!!\n");
                throw new InputMismatchException();
            }

            // Calculate the change
            double change = payment - totalPrice;
            System.out.printf("\nChange: Php %.2f",change);

            System.out.println("\n\nTHANK YOU FOR YOUR PURCHASE!!! PLEASE COME AGAIN!!!\n\n");

            // Delay before going back to Welcome
            System.out.println("Press enter to continue...");
            sc.nextLine();
            sc.nextLine();
            displayWelcome();
        }
        catch (InputMismatchException e){ // Display error message if there is an error
            Main.displayErrorMessage();
            calculateTotal();
        }
    }
}
