import java.util.*;

public class MilkTea extends Product{
    private final String [] flavors = {"Dark Choco", "Oreo\t", "Matcha\t", "Okinawa\t",
            "Red Velvet", "Strawberry", "Honey Dew", "Taro\t"};

    private final String [] sizes = {"16oz", "20oz"};

    private final int [] prices = {29, 39};

    @Override
    public void displayProduct(){
        Scanner scan = new Scanner(System.in);

        Main.clearConsole();

        try{ // Check for errors on user input
            System.out.println(" __________________________________________________________ ");
            System.out.println("|     Code    |    Size    |             Price             |");
            System.out.println("|_____________|____________|_______________________________|");
            for (int j = 0; j < sizes.length; j++){
                System.out.println("|      "+(j+1)+"      |    "+ sizes[j] +"    |\t\t  "+ prices[j] +"\t\t   |");
                System.out.println("|_____________|____________|_______________________________|");
            }

                System.out.print("\nEnter the code of the size: ");
                int sizeCode = scan.nextInt();

                // Throw an exception if code is not in the choices
                if (sizeCode < 1 || sizeCode > sizes.length) throw new InputMismatchException();

            System.out.println(" ____________________________________________ ");
            System.out.println("|                   MilkTea                  |");
            System.out.println("|____________________________________________|");
            System.out.println("|    Code    |             Flavor            |");
            System.out.println("|____________|_______________________________|");

            for (int i = 0; i < flavors.length; i++){
                System.out.println("|     "+(i+1)+"\t     |\t\t"+ flavors[i] +"\t     |");
                System.out.println("|____________|_______________________________|");
            }

            System.out.print("\nEnter the code of the flavor: ");
            int flavorCode = scan.nextInt();

            // Throw an exception if code is not in the choices
            if (flavorCode < 1 || flavorCode > flavors.length) throw new InputMismatchException();

            askQuantity(); // Ask user for item quantity

            displaySelection(); // Display a selection

            int choice = scan.nextInt();

            // Store the orders if not cancelled
            if (choice == 1 || choice == 2) {
                recordOrders(flavorCode, sizeCode);
            }

            evaluateChoice(choice);

        } // Display error message and restart input
        catch(InputMismatchException e){ // Display error message if there is an error
            Main.displayErrorMessage();
            Shop.displayMenu();
        }
    }
    private void recordOrders(int flavorCode, int sizeCode){
        // Store the order details in a Map
        Map<String, Object> order = new HashMap<>();
        order.put("flavor", flavors[flavorCode-1].replaceAll("\\s", ""));
        order.put("size", sizes[sizeCode-1]);
        order.put("quantity", quantity);
        order.put("subtotal", prices[sizeCode-1]*quantity);

        // Add the order to the List of orders
        Shop.orders.add(order);
    }
}
