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

public class Pipe<T> {
    private ArrayList<T> list;

    public Pipe() {
        this.list = new ArrayList<>();
    }
    
    public void putIntoPipe(T value) {
        list.add(value);
    }
    
    public T takeFromPipe() {
        if(list.isEmpty()) return null;
        
        return list.remove(0);
    }
    
    public boolean isInPipe() {
        return !list.isEmpty();
    }
}
