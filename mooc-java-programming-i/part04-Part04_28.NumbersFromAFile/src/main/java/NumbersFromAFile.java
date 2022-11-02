
import java.nio.file.Paths;
import java.util.Scanner;

public class NumbersFromAFile {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("File? ");
        String file = scanner.nextLine();
        System.out.print("Lower bound? ");
        int lowerBound = Integer.valueOf(scanner.nextLine());
        System.out.print("Upper bound? ");
        int upperBound = Integer.valueOf(scanner.nextLine());
        int tally = 0;
        
        try(Scanner fileReader = new Scanner(Paths.get(file))){
            while(fileReader.hasNextLine()){
                int number = Integer.valueOf(fileReader.nextLine());
                
                if(number >= lowerBound && number <= upperBound){
                    tally++;
                }
            }
        }catch(Exception e){
            System.out.println("File not found.");
        }
        
        System.out.println("Numbers: " + tally);
    }

}
