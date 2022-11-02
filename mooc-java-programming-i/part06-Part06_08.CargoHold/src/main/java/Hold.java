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

public class Hold {
    private ArrayList<Suitcase> luggages;
    private int maxWeight;
    
    public Hold(int maxWeight){
        this.maxWeight = maxWeight;
        this.luggages = new ArrayList<>();
    }
    
    public void addSuitcase(Suitcase suitcase){
        int newWeight = this.totalWeight() + suitcase.totalWeight();
        
        if(newWeight > this.maxWeight) return;
        
        luggages.add(suitcase);
    }
    
    public int totalWeight(){
        int total = 0;
        
        for(Suitcase luggage: luggages){
            total += luggage.totalWeight();
        }
        
        return total;
    }
    
    public void printItems(){
        for(Suitcase luggage: luggages){
            luggage.printItems();
        }
    }
    
    public String toString(){
        int size = this.luggages.size();
        
        if(this.luggages.isEmpty()) return "no suitcase (0 kg)";
        else if(size == 1){
            return size + " suitcase + (" + this.totalWeight() + " kg)";
        }
        
        return size + " suitcases + (" + this.totalWeight() + " kg)";
    }
}
