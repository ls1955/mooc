
import java.util.ArrayList;
import java.util.Scanner;

public class IndexOfSmallest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // implement here a program that reads user input
        // until the user enters 9999
        ArrayList<Integer> nums = new ArrayList<>();
        while(true){
            int num = Integer.valueOf(scanner.nextLine());
            
            if(num == 9999){
                break;
            }
            
            nums.add(num);
        }
        
        // after that, the program prints the smallest number
        // and its index -- the smallest number
        // might appear multiple times
        int min = nums.get(0);
        int minIndex = 0;
        
        for(int i = 0; i < nums.size(); i++){
            if(nums.get(i) < min){
                min = nums.get(i);
                minIndex = i;
            }
        }
        
        System.out.println("Smallest number: " + min);
        System.out.println("Found at index: " + minIndex);
        
    }
}
