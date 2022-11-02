
import java.util.Scanner;

public class SumOfThreeNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Write your program here
        System.out.println("Give the first number:");
        int numFirst = Integer.valueOf(scanner.nextLine());
        System.out.println("Give the second number:");
        int numSecond = Integer.valueOf(scanner.nextLine());
        System.out.println("Give the third number:");
        int numThird = Integer.valueOf(scanner.nextLine());
        int result = numFirst + numSecond + numThird;
        System.out.println("The sum of the numbers is " + result);
    }
}
