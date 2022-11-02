
import java.util.ArrayList;
import java.util.Scanner;

public class PersonalDetails {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String longestName = "";
        int totalBirthYears = 0;
        int userAmount = 0;
        
        while(true){
            String input = scanner.nextLine();
            
            if(input.equals("")){
                break;
            }
            
            String[] data = input.split(",");
            int dataAge = Integer.valueOf(data[1]);
            
            if(data[0].length() > longestName.length()){
                longestName = data[0];
            }
            
            totalBirthYears += dataAge;
            userAmount++;
        }
        
        double averageBirthYears = (1.0 * totalBirthYears) / userAmount;
        
        System.out.println("Longest name: " + longestName);
        System.out.println("Average of the birth years: " + averageBirthYears);
    }
}
