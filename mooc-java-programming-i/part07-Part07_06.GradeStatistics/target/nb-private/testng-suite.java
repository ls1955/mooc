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
    private PointList pointList;
    
    public UserInterface(Scanner scanner){
        this.scanner = scanner;
        this.pointList = new PointList();
    }
    
    public void start(){
        System.out.println("Enter point totals, -1 stops:");
        
        while(true){
            String input = scanner.nextLine();
            int point = Integer.valueOf(input);
        
            if(point < 0 || point > 100) continue;
            else if(point == -1) break;
            
            this.pointList.addPoint(point);
        }
        
        System.out.println("Point average (all): " + this.pointList.getAveragePoint());
        
        if(this.pointList.hasNoPassedPoint()){
            System.out.println("Point average (passing): -");
        }else{
            System.out.println("Point average (passing): " + this.pointList.getAveragePassedPoint());
        }
    }
}
