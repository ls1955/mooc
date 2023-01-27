
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LiteracyComparison {
    
    public static void main(String[] args) {
        try{
            Files.lines(Paths.get("literacy.csv"))
                 .map( row -> row.split(","))
                 .sorted((prev, curr)->{
                     return prev[5].compareTo(curr[5]);
                 }).forEach( data ->{
                     System.out.println(data[3] + " ("+ data[4] + ")," + data[2].replace(" (%)", "") + ", " + data[5]);
                 });
        }catch(Exception e){
            System.out.println("The file does not exist.");
        }
    }
}
