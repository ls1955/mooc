
import java.util.ArrayList;

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

public class BoxWithMaxWeight extends Box{
    private int capacity;
    private ArrayList<Item> items;

    public BoxWithMaxWeight(int capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }

    @Override
    public void add(Item item) {
        if((this.weightsOfItems() + item.getWeight()) <= this.capacity){
            this.items.add(item);
        }
    }
    
    private int weightsOfItems(){
        int total = 0;
        
        for(Item currItem: this.items){
            total += currItem.getWeight();
        }
        
        return total;
    }
    @Override
    public boolean isInBox(Item item){
        return this.items.contains(item);
    }
}
