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
import java.lang.StringBuilder;

public class Herd implements Movable{
    private ArrayList<Movable> movableObjects;

    public Herd(){
        this.movableObjects = new ArrayList<>();
    }
    
    public void addToHerd(Movable movable){
        this.movableObjects.add(movable);
    }
    
    public void move(int dx, int dy){
        for(Movable object: this.movableObjects){
            object.move(dx, dy);
        }
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        
        for(Movable object: this.movableObjects){
            stringBuilder.append(object.toString() + "\n");
        }
        
        return stringBuilder.toString();
    }
}
