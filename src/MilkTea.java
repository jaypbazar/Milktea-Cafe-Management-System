import java.util.*;

public class MilkTea {
    private final String [] flavors = {"Dark Choco", "Oreo\t", "Matcha\t", "Okinawa\t",
            "Red Velvet", "Strawberry", "Honey Dew", "Taro\t"};

    private final String [] sizes = {"16oz", "20oz"};

    private final int [] prices = {29, 39};

    public void displayMilkTea(){
        Scanner scan = new Scanner(System.in);

        while(true){
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

                System.out.println("\nEnter the quantity: ");
                quantity = scan.nextInt();

                System.out.println("Select the code of your choice: ");
                System.out.println("    1. Make another order");
                System.out.println("    2. Place order");
                System.out.println("    3. Cancel Order");

                int choice = scan.nextInt();

                // Store the orders if not cancelled
                if (choice != 3) {
                    recordOrders(flavorCode, sizeCode);
                }

                switch (choice){
                    case 1: // Display the menu for additional orders
                        Shop.displayMenu();
                        break;
                    case 2: // Move to payment
                        Shop.calculateTotal();
                        break;
                    case 3:
                        System.out.println("Order Cancelled.");
                        Shop.displayMenu();
                        break;
                    default:
                        throw new InputMismatchException();
                }
                break;

            } // Display error message and restart input
            catch(InputMismatchException e){ // Display error message if there is an error
                System.out.println("\nInvalid input! Please enter a valid input.");
                scan.nextLine(); // Absorb the invalid input

                // Delay program until user press enter
                System.out.println("\n\nPress enter to continue...");
                scan.nextLine();
            }
        }
    }
    private void recordOrders(int flavorCode, int sizeCode){
        Map<String, Object> order = new HashMap<>();
        order.put("flavor", flavors[flavorCode-1].replaceAll("\\s", ""));
        order.put("size", sizes[sizeCode-1]);
        order.put("quantity", quantity);

        Shop.orders.add(order);
    }
}
