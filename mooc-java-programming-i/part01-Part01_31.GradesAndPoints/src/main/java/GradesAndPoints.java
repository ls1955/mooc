
import java.util.Scanner;

public class GradesAndPoints {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Give points [0-100]:");
        int point = Integer.valueOf(scan.nextLine());
        String grade = "";
        
        if(point < 0){
            grade = "impossible!";
        }else if(point <= 49){
            grade = "failed";
        }else if(point <= 59){
            grade = "1";
        }else if(point <= 69){
            grade = "2";
        }else if(point <= 79){
            grade = "3";
        }else if(point <= 89){
            grade = "4";
        }else if(point <=100){
            grade = "5";
        }else{
            grade = "incredible!";
        }
        
        System.out.println("Grade: " + grade);
    }
}
