import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Coffee extends Product{
    private final String [] types = {"Espresso", "Americano", "Latt\u00e9\t", "Cappuccino",
            "Mocha\t", "Macchiato", "Cold Brew", "Drip Coffee"};

    private final int [] prices = {70, 100, 120, 130, 140, 120, 150, 80};

    @Override
    public void displayProduct(){
        Scanner scan = new Scanner(System.in);

        Main.clearConsole();

        System.out.println(" _______________________________________________________ ");
        System.out.println("|                    Coffee                  |          |");
        System.out.println("|____________________________________________|__________|");
        System.out.println("|    Code    |              Type             |	 Price	|");
        System.out.println("|____________|_______________________________|__________|");

        for (int i = 0; i < types.length; i++){
            System.out.println("|     "+(i+1)+"\t     |\t\t"+ types[i] +"\t     |\t  "+ prices[i] +"\t|");
            System.out.println("|____________|_______________________________|__________|");
        }

        try{ // Check for errors on user input
            System.out.print("\nEnter the code of the coffee: ");
            int typeCode = scan.nextInt();

            if (typeCode < 1 || typeCode > types.length) throw new InputMismatchException();

            askQuantity(); // Ask user for item quantity

            displaySelection(); // Display a selection

            int choice = scan.nextInt();

            // Store the orders if not cancelled
            if (choice != 3) {
                recordOrders(typeCode);
            }

            evaluateChoice(choice);
        }
        catch(InputMismatchException e){ // Display error message if there is an error
            System.out.println("\nInvalid input! Please enter a valid input.");
            scan.nextLine(); // Absorb the invalid input

            // Delay program until user press enter
            System.out.println("\n\nPress enter to continue...");
            scan.nextLine();

            Shop.displayMenu();
        }
    }
    private void recordOrders(int typeCode) {
        // Store the order details in a Map
        Map<String, Object> order = new HashMap<>();
        order.put("coffee_type", types[typeCode-1].replaceAll("\\t", ""));
        order.put("quantity", quantity);
        order.put("subtotal", prices[typeCode-1]*quantity);

        // Add the order to the List of orders
        Shop.orders.add(order);
    }
}
