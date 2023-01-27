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
import java.lang.Math;

public class ChangeHistory {
    private ArrayList<Double> histories;
    
    public ChangeHistory(){
        this.histories = new ArrayList<>();
    }
    
    public void add(double status){
        this.histories.add(status);
    }
    
    public void clear(){
        this.histories.clear();
    }
    
    public double maxValue(){
        double currMax = 0.0;
        
        for(double history: this.histories){
            currMax = Math.max(currMax, history);
        }
        
        return currMax;
    }
    
    public double minValue(){
        double currMin = 0.0;
        
        for(double history: this.histories){
            if(currMin == 0){
                currMin = history;
            }
            
            currMin = Math.min(currMin, history);
        }
        
        return currMin;
    }
    
    public double average(){
        if(this.histories.isEmpty()){
            return 0.0;
        }
        
        double sum = 0.0;
        
        for(double history: this.histories){
            sum += history;
        }
        
        return sum / this.histories.size();
    }
    
    @Override
    public String toString(){
        return this.histories.toString();
    }
}
