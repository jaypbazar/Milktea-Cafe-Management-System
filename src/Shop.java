import java.time.LocalDate;
import java.util.*;

public class Shop {
    private static final Scanner sc = Main.scanner;
    public static List<List<Map<String, Object>>> transactions = new ArrayList<>();
    private static double totalPrice;

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
            System.out.println("|      2     |      List of Transactions     |");
            System.out.println("|____________|_______________________________|");
            System.out.println("|      3     |             Exit              |");
            System.out.println("|____________|_______________________________|");

            try{ // Check for errors on user input
                System.out.print("\nEnter the code of your choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        totalPrice = 0;
                        Product.orderNumber++;

                        Product.orders = new ArrayList<>();

                        // Add a date and time the current order
                        Map<String, Object> orderDate = new HashMap<>();
                        orderDate.put("date", LocalDate.now());
                        Product.orders.add(orderDate);

                        displayMenu();
                        break;
                    case 2:
                        /* NOTE:
                         * username = Employee
                         * password = admin123
                         */
                        checkEmployeeLogin();
                        break;
                    case 3:
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
            System.out.println("|      3     |         Cancel Orders         |");
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
                        Product.orders.clear();
                        Product.orderNumber--;

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
        totalPrice = 0;

        Main.clearConsole();

        // Display the order details summary
        displayOrderDetails();

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

    private static void displayOrderDetails(){
        int index = Product.orderNumber - 1;

        System.out.println("   ============================================");
        System.out.println("                  ORDER DETAILS                ");
        System.out.println("   ============================================");
        System.out.println("\n\t\t  ORDER #" + Product.orderNumber + "\n\t      Date: " + transactions.get(index).get(0).get("date") +
                "\n\nProduct\t\t    Quantity\t\t  Price");

        List<Map<String, Object>> orders = transactions.get(index);

        for (Map<String, Object> order : orders) {
            //Skip the date
            if (order.containsKey("date")){
                continue;
            }

            // Display for MilkTea
            if (order.containsKey("flavor")) {
                System.out.println(
                        order.get("size")+" "+order.get("flavor") +
                        "\t\t"+order.get("quantity")+
                        "\t\t"+String.format("Php %.2f", Double.parseDouble(order.get("subtotal").toString()))
                );
            }
            // Display for Coffee
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
    }

    private static void checkEmployeeLogin(){
        System.out.println("\nAUTHORIZED PERSONNEL ONLY!!!");

        System.out.print("\nUsername: ");
        String username = sc.next();

        System.out.print("\nPassword: ");
        String password = sc.next();
        sc.nextLine();

        if (!username.equals("Employee1") && !password.equals("admin123")){
            System.out.println("\nIncorrect username or password!");
        }
        else {
            if (transactions.isEmpty()){
                System.out.println("\nNo transactions has been made...");
            }
            else {
                displayTransactions();
            }
        }

        // Delay program until user press enter
        System.out.println("\n\nPress enter to continue...");
        sc.nextLine();

        displayWelcome();
    }

    private static void displayTransactions() {
        Main.clearConsole();

        int orderNumber = 0;

        System.out.println(" ======================================================= ");
        System.out.println("                  LIST OF TRANSACTIONS                   ");
        System.out.println(" ======================================================= ");

        for (List<Map<String, Object>> orders : transactions){
            double total = 0;
            orderNumber++;

            // Display order number and date purchased
            System.out.println("\n\t\t     ORDER #" + orderNumber + "\n\n\t\t Date: " + orders.get(0).get("date") +
                    "\n\nProduct\t\t    Quantity\t\t  Price");

            for (Map<String, Object> order : orders){

                //Skip the date
                if (order.containsKey("date")){
                    continue;
                }

                // Display for MilkTea
                if (order.containsKey("flavor")) {
                    System.out.println(
                            order.get("size")+" "+order.get("flavor") +
                                    "\t\t"+order.get("quantity") +
                                    "\t\t"+String.format("Php %.2f", Double.parseDouble(order.get("subtotal").toString()))
                    );
                }
                // Display for Coffee
                else {
                    System.out.println(
                            order.get("coffee_type") +
                                    "\t\t"+order.get("quantity") +
                                    "\t\t"+String.format("Php %.2f", Double.parseDouble(order.get("subtotal").toString()))
                    );
                }
                total += (int) order.get("subtotal");
            }

            System.out.printf("\nTotal Price: \t\t\t\tPhp %.2f%n", total);
            System.out.println("\n =======================================================\n");
        }
    }
}
