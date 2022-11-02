
import java.util.Scanner;

public class LineByLine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true){
            String input = scanner.nextLine();
            
            if(input.equals("")){
                break;
            }
            
            String[] lines = input.split(" ");
            for(String line: lines){
                System.out.println(line);
            }
        }
    }
}
