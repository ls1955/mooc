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
import java.nio.file.Paths;
import java.util.ArrayList;

public class UserInterface {
    private Scanner scanner;
    private ArrayList<Recipe> recipes;
    
    public UserInterface(Scanner scanner){
        this.scanner = scanner;
        this.recipes = new ArrayList<Recipe>();
    }
    
    public void start(){
        System.out.print("File to read: ");
        String filePath = this.scanner.nextLine();
        
        try(Scanner fileReader = new Scanner(Paths.get(filePath))){
            while(fileReader.hasNextLine()){
                Recipe currRecipe = new Recipe();
                int counter = 0;
                                
                while(fileReader.hasNextLine()){
                    String data = fileReader.nextLine();
                    
                    if(data.isEmpty()) break;
                    
                    if(counter == 0){
                        currRecipe.setName(data);
                    }else if(counter == 1){
                        currRecipe.setDuration(Integer.valueOf(data));
                    }else{
                        currRecipe.addIngredient(data);
                    }
                    
                    counter++;
                }
                
                this.recipes.add(currRecipe);
            }
            
            this.showCommands();
            
            while(true){
                System.out.println("Enter command: ");
                String command = this.scanner.nextLine();
                
                if(command.equals("stop")) break;
                
                this.processCommand(command);
            }
            
        }catch(Exception e){
            System.out.println("File do not exist");
        }
    }
    
    private void showCommands(){
        System.out.println("Commands");
        System.out.println("list - lists the recipes");
        System.out.println("stop - stops the program");
        System.out.println("find name - searches recipes by name");
        System.out.println("find cooking time - searches recipes by cooking time");
        System.out.println("find ingredient - searches recipes by ingredient");
    }
    
    private void processCommand(String command){
        if(command.equals("list")){
            System.out.println("Recipes:");
            System.out.println("");
            
            for(Recipe recipe: this.recipes){
                System.out.println(recipe);
            }
        }else if(command.equals("find name")){
            System.out.print("Searched word: ");
            String searchWord = this.scanner.nextLine();
            
            System.out.println("Recipes:");
            System.out.println("");
            
            for(Recipe recipe: this.recipes){
                if(recipe.getName().contains(searchWord)){
                    System.out.println(recipe);
                    System.out.println("");
                }
            }
        }else if(command.equals("find cooking time")){
            System.out.print("Max cooking time: ");
            int maxDuration = Integer.valueOf(this.scanner.nextLine());
            
            System.out.println("Recipes:");
            System.out.println("");
            
            for(Recipe recipe: this.recipes){
                if(recipe.getDuration() <= maxDuration){
                    System.out.println(recipe);
                    System.out.println("");
                }
            }
        }else if(command.equals("find ingredient")){
            System.out.println("Ingredient: ");
            String ingredient = this.scanner.nextLine();
            
            System.out.println("Recipes:");
            System.out.println("");
            
            for(Recipe recipe: this.recipes){
                if(recipe.getIngredients().contains(ingredient)){
                    System.out.println(recipe);
                }
                System.out.println("");
            }
        }
    }
}
