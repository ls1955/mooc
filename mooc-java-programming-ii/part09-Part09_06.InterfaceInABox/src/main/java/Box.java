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

public class Box implements Packable{
    private double maxCapacity;
    private ArrayList<Packable> items;

    public Box(double maxCapacity){
        this.maxCapacity = maxCapacity;
        this.items = new ArrayList<>();
    }
    
    public void add(Packable item){
        if((this.weight() + item.weight()) < this.maxCapacity){
            this.items.add(item);
        }
    }
    
    public double weight(){
        double weight = 0;
        
        for(Packable item: this.items){
            weight += item.weight();
        }
        
        return weight;
    }
    
    @Override
    public String toString(){
        return ("Box: " + this.items.size() + " items, total weight " + this.weight() + " kg");
    }
}
