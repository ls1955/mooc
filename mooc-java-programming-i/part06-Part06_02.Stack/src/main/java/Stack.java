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

public class Stack {
    private ArrayList<String> values;
    
    public Stack(){
        this.values = new ArrayList<>();
    }
    
    public boolean isEmpty(){
        return this.values.isEmpty();
    }
    
    public void add(String value){
        if(this.values.contains(value)) return;
        
        this.values.add(value);
    }
    
    public ArrayList<String> values(){
        return this.values;
    }
    
    public String take(){
        return this.values.remove(this.values.size() - 1);
    }
}
