
import java.lang.StringBuilder;

public class Program {

    public static void main(String[] args) {
        // Test your method here
    }

    public static String arrayAsString(int[][] array) {
        StringBuilder bobTheBuilder = new StringBuilder();
        
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                bobTheBuilder.append(array[i][j]);
            }
            
            bobTheBuilder.append("\n");
        }
        
        return bobTheBuilder.toString();
    }
}
