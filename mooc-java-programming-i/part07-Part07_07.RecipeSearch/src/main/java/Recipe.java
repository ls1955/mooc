/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cheong
 */
import java.util.ArrayList;

public class Recipe {
    private String name;
    private int duration;
    private ArrayList<String> ingredients;
    
    public Recipe(){
        this.ingredients = new ArrayList<>();
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getDuration(){
        return this.duration;
    }
    
    public ArrayList<String> getIngredients(){
        return this.ingredients;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setDuration(int duration){
        this.duration = duration;
    }
    
    public void addIngredient(String ingredient){
        this.ingredients.add(ingredient);
    }
    
    public String toString(){
        return (this.name + ", cooking time: " + this.duration + "\n");
    }
}
