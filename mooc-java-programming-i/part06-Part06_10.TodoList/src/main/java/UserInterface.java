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
    private TodoList list;
    private Scanner scanner;
    
    public UserInterface(TodoList list, Scanner scanner){
        this.list = list;
        this.scanner = scanner;
    }
    
    public void start(){
        while(true){
            String input = this.scanner.nextLine();
            
            if(input.equals("stop")) break;
            
            this.processInput(input);
        }
    }
    
    private void processInput(String input){
        if(input.equals("add")){
            this.addTask();
        }else if(input.equals("list")){
            this.listTasks();
        }else if(input.equals("remove")){
            this.removeTask();
        }
    }
    
    private void addTask(){
        System.out.println("To add: ");
        String task = this.scanner.nextLine();
        
        this.list.add(task);
    }
    
    private void listTasks(){
        this.list.print();
    }
    
    private void removeTask(){
        int removeIndex = Integer.valueOf(this.scanner.nextLine());
        this.list.remove(removeIndex);
    }
}
