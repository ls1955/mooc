/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cheong
 */

public class Hideout<T> {
    private T object;

    public Hideout() {}
    
    public void putIntoHideout(T toHide) {
        object = toHide;
    }
    
    public T takeFromHideout() {
        if (object == null) return object;
        
        T tempObject = object;
        object = null;
        
        return tempObject;
    }
    
    public boolean isInHideout() {
        return object != null;
    }
}
