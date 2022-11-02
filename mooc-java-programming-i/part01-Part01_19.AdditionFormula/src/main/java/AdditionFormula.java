
import java.util.Scanner;

public class AdditionFormula {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // write your program here
        System.out.println("Give the first number:");
        int numFirst = Integer.valueOf(scanner.nextLine());
        System.out.println("Give the second number:");
        int numSecond = Integer.valueOf(scanner.nextLine());
        int result = numFirst + numSecond;
        System.out.println(numFirst + " + " + numSecond + " = " + result);
    }
}
