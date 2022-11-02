/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cheong
 */
public class Item {
    private String identifier;
    private String name;

    public Item(String identifier, String name){
        this.identifier = identifier;
        this.name = name;
    }
    
    public String getIdentifier(){
        return this.identifier;
    }
    
    public String getName(){
        return this.name;
    }
    
    public boolean equals(Object comparedObj){
        if(this == comparedObj) return true;
        else if(!(comparedObj instanceof Item)) return false;
        
        Item comparedItem = (Item) comparedObj;
        
        return(this.identifier.equals(comparedItem.getIdentifier()));
    }
    
    public String toString(){
        return (this.getIdentifier() + ": " + this.getName());
    }
}
