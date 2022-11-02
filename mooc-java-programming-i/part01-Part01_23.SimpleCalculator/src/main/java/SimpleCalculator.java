
import java.util.Scanner;

public class SimpleCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Write your program here
        System.out.println("Give the first number:");
        int numFirst = Integer.valueOf(scanner.nextLine());
        System.out.println("Give the second number:");
        int numSecond = Integer.valueOf(scanner.nextLine());
        System.out.println(numFirst + " + " + numSecond + " = " + (numFirst + numSecond));
        System.out.println(numFirst + " - " + numSecond + " = " + (numFirst - numSecond));
        System.out.println(numFirst + " * " + numSecond + " = " + (numFirst * numSecond));
        System.out.println(numFirst + " / " + numSecond + " = " + (1.0 * numFirst / numSecond));
    }
}
