import java.util.InputMismatchException;

public abstract class Product {
    protected int quantity;

    public abstract void displayProduct();

    protected void askQuantity(){
        System.out.print("\nEnter the quantity: ");
        quantity = Main.scanner.nextInt();

        // Throw an exception if quantity is less than 1
        if (quantity < 1) throw new InputMismatchException();
    }
    protected void displaySelection(){
        System.out.println("Select the number of your choice: ");
        System.out.println("    1. Make another order");
        System.out.println("    2. Place order");
        System.out.println("    3. Cancel Order");
    }

    protected void evaluateChoice(int choice){
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
    }
}
