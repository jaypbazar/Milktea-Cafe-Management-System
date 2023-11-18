import java.util.InputMismatchException;
import java.util.Scanner;

public class MilkTea {
    private final String [] flavor = {"Dark Choco", "Oreo\t", "Matcha\t", "Okinawa\t",
            "Red Velvet", "Strawberry", "Honey Dew", "Taro\t"};

    private final String [] size = {"16oz", "20oz"};

    private final int [] price = {29, 39};

    private int quantity;
    private int total;


    public void displayMilktea(){
        Scanner scan = new Scanner(System.in);

        while(true){
            Main.clearConsole();

            System.out.println(" __________________________________________________________ ");
            System.out.println("|     Code    |    Size    |             Price             |");
            System.out.println("|_____________|____________|_______________________________|");
            for (int j = 0; j < size.length; j++){
                System.out.println("|      "+(j+1)+"      |    "+ size[j] +"    |\t\t  "+ price[j] +"\t\t   |");
                System.out.println("|_____________|____________|_______________________________|");
            }
            try{ // Check for errors on user input
                System.out.print("\nEnter the code of the size: ");
                int sizeCode = scan.nextInt();

                //TODO: Implement input calculations

            }
            catch(InputMismatchException e){ // Display error message if there is an error
                System.out.println("\nInvalid input! Please enter a valid input.");
                scan.nextLine(); // Absorb the invalid input

                // Delay program until user press enter
                System.out.println("\n\nPress enter to continue...");
                scan.nextLine();
            }

            System.out.println(" ____________________________________________ ");
            System.out.println("|                   Milktea                  |");
            System.out.println("|____________________________________________|");
            System.out.println("|    Code    |             Flavor            |");
            System.out.println("|____________|_______________________________|");

            for (int i = 0; i < flavor.length; i++){
                System.out.println("|     "+(i+1)+"\t     |\t\t"+ flavor[i] +"\t     |");
                System.out.println("|____________|_______________________________|");
            }

            try{ // Check for errors on user input
                System.out.print("\nEnter the code of the flavor: ");
                int flavorCode = scan.nextInt();

                //TODO: Record orders
                break;

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
