
import java.util.Scanner;

public class SquareRootOfSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numFirst = Integer.valueOf(scanner.nextLine());
        int numSecond = Integer.valueOf(scanner.nextLine());
        int sum = numFirst + numSecond;
        double squareRootedSum = Math.sqrt(sum);
        
        System.out.println(squareRootedSum);
    }
}
