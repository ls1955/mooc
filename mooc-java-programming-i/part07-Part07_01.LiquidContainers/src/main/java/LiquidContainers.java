
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int container1Volume = 0;
        int container2Volume = 0;
        int containerMaxVolume = 100;

        while (true) {
            System.out.print("> ");
            System.out.println("First: " + container1Volume + "/100");
            System.out.println("Second: " + container2Volume + "/100");

            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }
            
            String[] inputArr = input.split(" ");
            String command = inputArr[0];
            
            if(command.equals("add")){
                int addAmount = Integer.valueOf(inputArr[1]);
                
                if(addAmount > 0) container1Volume += addAmount;
                if(container1Volume > 100) container1Volume = 100;
            }else if(command.equals("move")){
                int moveAmount = Integer.valueOf(inputArr[1]);
                
                if(moveAmount < 0) continue;
                else if(moveAmount > container1Volume){
                    moveAmount = container1Volume;
                }
                
                container1Volume -= moveAmount;
                container2Volume += moveAmount;
                
                if(container2Volume > containerMaxVolume){
                    container2Volume = containerMaxVolume;
                }
            }else if(command.equals("remove")){
                int removeAmount = Integer.valueOf(inputArr[1]);
                
                if(removeAmount > container2Volume){
                    removeAmount = container2Volume;
                }
                
                container2Volume -= removeAmount;
            }

        }
    }

}
