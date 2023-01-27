
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int firstVolume = 0;
        int secondVolume = 0;

        while (true) {
            System.out.println("First: " + firstVolume + "/100");
            System.out.println("Second: " + secondVolume + "/100");
            
            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }

            String[] parts = input.split(" ");
            String command = parts[0];
            int amount = Integer.valueOf(parts[1]);

            if (command.equals("add")) {
                if (amount < 0) {
                    break;
                }

                firstVolume += amount;

                if (firstVolume > 100) {
                    firstVolume = 100;
                }

            } else if (command.equals("move")) {
                if (amount < 0) {
                    break;
                }

                if (amount > firstVolume) {
                    amount = firstVolume;
                }

                firstVolume -= amount;
                secondVolume += amount;

                if (secondVolume > 100) {
                    secondVolume = 100;
                }
            } else if (command.equals("remove")) {
                if (amount < 0) {
                    break;
                }

                if (amount > secondVolume) {
                    amount = secondVolume;
                }

                secondVolume -= amount;
            }
        }
    }

}
