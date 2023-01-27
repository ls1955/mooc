
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // toteuta ohjelmasi tänne
        ArrayList<String> inputs = new ArrayList<>();
        
        System.out.println("Input numbers, type \"end\" to stop.");
        while(true){
            String input = scanner.nextLine();
            
            if(input.equals("end"))
                break;
            
            inputs.add(input);
        }
        
        System.out.println("Print the average of the positive numbers or the negative numbers? (n/p)");
        
        String input = scanner.nextLine();
        if(input.equals("p")){
            double averageOfPositiveNums = inputs.stream()
                                                 .mapToInt(data -> Integer.valueOf(data))
                                                 .filter(num -> num > 0)
                                                 .average()
                                                 .getAsDouble();
            
            System.out.println("Average of the positive numbers: " + averageOfPositiveNums);
        }else if(input.equals("n")){
            double averageOfNegativeNums = inputs.stream()
                                                 .mapToInt(data -> Integer.valueOf(data))
                                                 .filter(num -> num < 0)
                                                 .average()
                                                 .getAsDouble();
            
            System.out.println("Average of the negative numbers: " + averageOfNegativeNums);
        }
    }
}
