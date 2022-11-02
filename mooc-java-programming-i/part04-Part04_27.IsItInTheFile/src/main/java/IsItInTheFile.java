
import java.nio.file.Paths;
import java.util.Scanner;

public class IsItInTheFile {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Name of the file:");
        String file = scanner.nextLine();

        System.out.println("Search for:");
        String searchedFor = scanner.nextLine();
        Boolean foundFlag = false;
        
        try(Scanner fileReader = new Scanner(Paths.get(file))){
            while(fileReader.hasNextLine()){
                String data = fileReader.nextLine();
                
                if(data.equals(searchedFor)){
                    System.out.println("Found!");
                    foundFlag = true;
                }
            }
        }catch(Exception e){
            System.out.println("Reading the file " + file + " failed.");
        }
        
        if(!foundFlag){
            System.out.println("Not found.");
        }
    }
}
