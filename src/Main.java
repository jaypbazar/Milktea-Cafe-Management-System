import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Shop.displayWelcome();
    }

    // Remove all the text in the console
    public static void clearConsole(){
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Error clearing the console!");
        }
    }
}
