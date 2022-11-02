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

public class UserInterface {
    private Scanner scanner;
    private ArrayList<Bird> birds;
    
    public UserInterface(Scanner scanner){
        this.scanner = scanner;
        this.birds = new ArrayList<>();
    }
    
    public void start(){
        while(true){
            System.out.print("? ");
            String command = this.scanner.nextLine();
        
            if(command.equals("Quit")) break;
            
            this.processCommand(command);
        }
    }
    
    private void processCommand(String command){
        if(command.equals("Add")){
            this.addSubroutine();
        }else if(command.equals("Observation")){
            this.observationSubroutine();
        }else if(command.equals("All")){
            this.allSubroutine();
        }else if(command.equals("One")){
            this.oneSubroutine();
        }
    }
    
    private void addSubroutine(){
        System.out.print("Name: ");
        String name = this.scanner.nextLine();
        System.out.print("Name in Latin: ");
        String latinName = this.scanner.nextLine();
            
        this.birds.add(new Bird(name, latinName));
    }
    
    private void observationSubroutine(){
        System.out.print("Bird? ");
        String name = this.scanner.nextLine();
        boolean hasResult = false;
            
        for(Bird bird: this.birds){
            if(bird.getName().equals(name)){
                bird.addObservationAmount();
                hasResult = true;
            }
        }
            
        if(!hasResult){
            System.out.println("Not a bird!");
        }
    }
    
    private void allSubroutine(){
        for(Bird bird: this.birds){
            System.out.println(bird);
        }
    }
    
    private void oneSubroutine(){
        System.out.print("Bird? ");
        String name = this.scanner.nextLine();
        
        for(Bird bird: this.birds){
            if(bird.getName().equals(name)){
                System.out.println(bird);
            }
        }
    }
}
