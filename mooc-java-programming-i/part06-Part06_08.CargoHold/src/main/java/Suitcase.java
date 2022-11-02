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

public class Suitcase {
    private ArrayList<Item> items;
    private int maxWeight;
    
    public Suitcase(int maxWeight){
        this.items = new ArrayList<>();
        this.maxWeight = maxWeight;
    }
    
    public void addItem(Item item){
        int newWeight = this.totalWeight() + item.getWeight();
        
        if(newWeight > this.maxWeight) return;
        
        this.items.add(item);
    }
    
    public Item heaviestItem(){
        if(this.items.isEmpty()) return null;
        
        Item currHeaviest = this.items.get(0);
        for(Item item: this.items){
            if(item.getWeight() > currHeaviest.getWeight()){
                currHeaviest = item;
            }
        }
        
        return currHeaviest;
    }
    
    public int totalWeight(){
        int total = 0;
        
        for(Item item: this.items){
            total += item.getWeight();
        }
        
        return total;
    }
    
    public void printItems(){
        for(Item item: this.items){
            System.out.println(item);
        }
    }
    
    public String toString(){
        int size = this.items.size();
        
        if(this.items.isEmpty()) return "no items (0 kg)";
        else if(size == 1){
            return size + " item + (" + this.totalWeight() + " kg)";
        }
        
        return size + " items + (" + this.totalWeight() + " kg)";
    }
}
