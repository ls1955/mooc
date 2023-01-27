
import java.util.Scanner;

public class LiquidContainers2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        Container containerFirst = new Container();
        Container containerSecond = new Container();
        

        while (true) {
            System.out.println("First: " + containerFirst);
            System.out.println("Second: " + containerSecond);
            
            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }

            String[] parts = input.split(" ");
            String command = parts[0];
            int amount = Integer.valueOf(parts[1]);

            if (command.equals("add")) {
                containerFirst.add(amount);
            } else if (command.equals("move")) {
                
                if (amount > containerFirst.contains()) {
                    amount = containerFirst.contains();
                }

                containerFirst.remove(amount);
                containerSecond.add(amount);
            } else if (command.equals("remove")) {
                containerSecond.remove(amount);
            }
        }
    }

}
