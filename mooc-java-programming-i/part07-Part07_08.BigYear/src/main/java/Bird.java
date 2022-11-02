/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cheong
 */
public class Bird {
    private String name;
    private String latinName;
    private int observationAmount;
    
    public Bird(String name, String latinName){
        this.name = name;
        this.latinName = latinName;
        this.observationAmount = 0;
    }
    
    public void addObservationAmount(){
        this.observationAmount++;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getObservationAmount(){
        return this.observationAmount;
    }
    
    @Override
    public String toString(){
        return (this.name + " (" + this.latinName + "): " + this.observationAmount + " observations");
    }
}
