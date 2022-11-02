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

public class Package {
    private ArrayList<Gift> packs;
    
    public Package(){
        this.packs = new ArrayList<>();
    }
    
    public void addGift(Gift gift){
        this.packs.add(gift);
    }
    
    public int totalWeight(){
        int result = 0;
        
        for(Gift gift: this.packs){
            result += gift.getWeight();
        }
        
        return result;
    }
}
