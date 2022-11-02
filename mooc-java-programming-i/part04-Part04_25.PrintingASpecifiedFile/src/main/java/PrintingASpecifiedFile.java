
import java.nio.file.Paths;
import java.util.Scanner;

public class PrintingASpecifiedFile {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Which file should have its contents printed?");
        String fileName = scanner.nextLine();
        
        try(Scanner fileReader = new Scanner(Paths.get(fileName))){
            while(fileReader.hasNextLine()){
                System.out.println(fileReader.nextLine());
            }
        }catch(Exception e){
            System.out.println("Beep Beep Boop Boop");
            System.out.println("Error: " + e.getMessage());
        }
    }
}
