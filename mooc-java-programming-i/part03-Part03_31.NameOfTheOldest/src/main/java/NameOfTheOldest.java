
import java.util.Scanner;

public class NameOfTheOldest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maxAge = 0;
        String oldestName = "";
        
        while(true){
            String input = scanner.nextLine();
            
            if(input.equals("")){
                break;
            }
            
            String[] data = input.split(",");
            int dataAge = Integer.valueOf(data[1]);
            
            if(dataAge > maxAge){
                maxAge = dataAge;
                oldestName = data[0];
            }
        }
        
        System.out.println("Name of the oldest: " + oldestName);
    }
}
