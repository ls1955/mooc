
import java.util.Scanner;

public class SumOfASequenceTheSequel {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("First number?");
        int numFirst = Integer.valueOf(scanner.nextLine());
        System.out.println("Second number?");
        int numSecond = Integer.valueOf(scanner.nextLine());
        int sum = 0;
        
        while(numFirst <= numSecond){
            sum += numFirst;
            numFirst++;
        }
        
        System.out.println("The sum is " + sum);
    }
}
