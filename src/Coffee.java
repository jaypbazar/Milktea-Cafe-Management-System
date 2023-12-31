import java.time.LocalDate;
import java.util.*;

public class Coffee extends Product{
    private final Scanner sc = Main.scanner;
    private final String [] types = {"Espresso", "Americano", "Latt\u00e9\t", "Cappuccino",
            "Mocha\t", "Macchiato", "Cold Brew", "Drip Coffee"};

    private final int [] prices = {70, 100, 120, 130, 140, 120, 150, 80};

    @Override
    public void displayProduct(){
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
            int typeCode = sc.nextInt();

            if (typeCode < 1 || typeCode > types.length) throw new InputMismatchException();

            askQuantity(); // Ask user for item quantity

            displaySelection(); // Display a selection

            System.out.print("Choice: ");
            int choice = sc.nextInt();

            // Store the orders if not cancelled
            if (choice == 1 || choice == 2) {
                // Record the coffee orders
                recordOrders(typeCode);
            }

            evaluateChoice(choice);
        }
        catch(InputMismatchException e){ // Display error message if there is an error
            Main.displayErrorMessage();
            Shop.displayMenu();
        }
    }
    private void recordOrders(int typeCode) {
        // Store the order details in a Map
        Map<String, Object> order = new HashMap<>();
        order.put("coffee_type", types[typeCode-1]);
        order.put("quantity", quantity);
        order.put("subtotal", prices[typeCode-1] * quantity);

        // Add the order to the List of orders
        orders.add(order);
    }
}
