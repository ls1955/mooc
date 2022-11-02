
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class SportStatistics {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String fileName = scan.nextLine();
        
        try(Scanner fileReader = new Scanner(Paths.get(fileName))){
            System.out.println("Team:");
            String teamName = scan.nextLine();
                
            int gamePlayed = 0;
            int wins = 0;
            int losses = 0;
                       
            while(fileReader.hasNextLine()){
                String[] data = fileReader.nextLine().split(",");
                String homeTeam = data[0];
                String visitingTeam = data[1];
                int homeTeamPoints = Integer.valueOf(data[2]);
                int visitingTeamPoints = Integer.valueOf(data[3]);
                
                if(teamName.equals(homeTeam)){
                    gamePlayed++;
                    
                    if(homeTeamPoints > visitingTeamPoints) wins++;
                    else if(homeTeamPoints < visitingTeamPoints) losses++;
                }else if(teamName.equals(visitingTeam)){
                    gamePlayed++;
                    
                    if(visitingTeamPoints > homeTeamPoints) wins++;
                    else if(visitingTeamPoints < homeTeamPoints) losses++;
                }
            }
            
            System.out.println("Games: " + gamePlayed);
            System.out.println("Wins: " + wins);
            System.out.println("Losses: " + losses);
        }catch(Exception e){
            System.out.println("File not found.");
        }
    }

}
