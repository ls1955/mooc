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

public class OneItemBox extends Box{
    private ArrayList<Item> slot;

    public OneItemBox() {
        this.slot = new ArrayList<>();
    }

    @Override
    public void add(Item item) {
        if(this.slot.isEmpty()){
            this.slot.add(item);
        }
    }
    
    @Override
    public boolean isInBox(Item item){
        return this.slot.contains(item);
    }
}
