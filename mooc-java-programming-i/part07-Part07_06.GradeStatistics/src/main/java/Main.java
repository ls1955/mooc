import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        // Write your program here -- consider breaking the program into 
        // multiple classes.
        Scanner scanner = new Scanner(System.in);
        Statistics points = new Statistics();
        Statistics passedPoints = new Statistics();
        UserInterface ui = new UserInterface(scanner, points, passedPoints);
        
        ui.start();
    }
}
