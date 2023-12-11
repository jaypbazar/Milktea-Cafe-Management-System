import java.util.InputMismatchException;
import java.util.Scanner;

public class Coffee {
    String [] types = {"Espresso", "Americano", "Latt\u00e9\t", "Cappuccino",
            "Mocha\t", "Macchiato", "Cold Brew", "Drip Coffee"};

    int [] prices = {70, 100, 120, 130, 140, 120, 150, 80};

    void displayCoffee(){
        Scanner scan = new Scanner(System.in);

        while(true){
            Main.clearConsole();

            System.out.println(" _______________________________________________________ ");
            System.out.println("|                    Coffee                  |          |");
            System.out.println("|____________________________________________|__________|");
            System.out.println("|    Code    |              Type             |	 Price	|");
            System.out.println("|____________|_______________________________|__________|");

            for (int i = 0; i < type.length; i++){
                System.out.println("|     "+(i+1)+"\t     |\t\t"+ type[i] +"\t     |\t  "+ price[i] +"\t|");
                System.out.println("|____________|_______________________________|__________|");
            }

            try{ // Check for errors on user input
                System.out.print("\nEnter the code of the coffee: ");
                int typeCode = scan.nextInt();

                //TODO: Implement input calculations
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
