
import java.util.Scanner;

public class AverageOfPositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int counter = 0;
        
        while(true){
            int inputNum = Integer.valueOf(scanner.nextLine());
            
            if(inputNum == 0){
                break;
            }
            
            if(inputNum > 0){
                sum += inputNum;
                counter++;
            }
        }
        
        if(counter == 0){
            System.out.println("Cannot calculate the average");
        }else{
            double average = (1.0 * sum) / counter;
            System.out.println(average);
        }
    }
}
