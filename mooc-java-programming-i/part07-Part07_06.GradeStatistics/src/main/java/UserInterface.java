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

public class UserInterface {
    private Scanner scanner;
    private Statistics points;
    private Statistics passedPoints;
    
    public UserInterface(Scanner scanner, Statistics points, Statistics passedPoints){
        this.scanner = scanner;
        this.points = points;
        this.passedPoints = passedPoints;
    }
    
    public void start(){
        System.out.println("Enter point totals, -1 stops:");
        
        while(true){
            int input = Integer.valueOf(scanner.nextLine());
            
            if(input == -1) break;
            else if(input < 0 || input > 100){
                continue;
            }
            
            if(input >= 50) this.passedPoints.add(input);
            
            this.points.add(input);
        }
        
        System.out.println("Point average (all): " + this.points.average());
        
        if(this.passedPoints.size() == 0){
            System.out.println("Point average (passing): -");
            System.out.println("Pass percentage: 0.0");
        }else{
            System.out.println("Point average (passing): " + this.passedPoints.average());
            System.out.println("Pass percentage: " + this.passPercentage());
        }
        
        System.out.println("Grade distribution:");
        
        this.points.printGrade();
    }
    
    public double passPercentage(){
        double ratio = (1.0 * this.passedPoints.size()) / this.points.size();
        return (100 * ratio);
    }
}
