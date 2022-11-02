/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cheong
 */

import java.util.Scanner;
import java.util.ArrayList;

public class ProceduralApproach {
    public void start(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> points = new ArrayList<Integer>();
        ArrayList<Integer> passedPoints = new ArrayList<Integer>();
        int[] grades = new int[6];
        
        System.out.println("Enter point totals, -1 stops:");
        
        while(true){
            int input = Integer.valueOf(scanner.nextLine());
            
            if(input == -1) break;
            else if(input < 0 || input > 100) continue;
            
            points.add(input);
            if(input >= 50){
                passedPoints.add(input);
            }
            
            if(input < 50) grades[0]++;
            else if(input < 60) grades[1]++;
            else if(input < 70) grades[2]++;
            else if(input < 80) grades[3]++;
            else if(input < 90) grades[4]++;
            else grades[5]++;
            
        }
        
        if(points.isEmpty()){
            System.out.println("Point average (all): 0.0");
        }else{
            int totalPoints = 0;
            for(int i=0; i<points.size(); i++){
                totalPoints += points.get(i);
            }
            double averagePoints = (1.0 * totalPoints) / points.size();
            System.out.println("Point average (all): " + averagePoints);
        }
        
        if(passedPoints.isEmpty()){
            System.out.println("Point average (passing): -");
        }else{
            int totalPassedPoints = 0;
            for(int i=0; i<passedPoints.size(); i++){
                totalPassedPoints += passedPoints.get(i);
            }
            double averagePassedPoints = (1.0 * totalPassedPoints) / passedPoints.size();
            
            System.out.println("Point average (passing): " + averagePassedPoints);
        }
        
        double passingPercentage = 100 * ((1.0 * passedPoints.size()) / points.size());
        System.out.println("Pass percentage: " + passingPercentage);
        
        System.out.println("Grade distribution: ");
        for(int i=5; i>=0; i--){
            System.out.print(i + ":");
            while(grades[i] > 0){
                System.out.print("*");
                grades[i]--;
            }
            System.out.println("");
        }
    }
}
