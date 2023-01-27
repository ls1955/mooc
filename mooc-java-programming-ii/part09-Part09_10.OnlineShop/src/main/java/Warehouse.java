/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cheong
 */

import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class Warehouse {
    private Map<String, Integer> productAndPrice;
    private Map<String, Integer> productAndStock;

    public Warehouse() {
        this.productAndPrice = new HashMap<>();
        this.productAndStock = new HashMap<>();
    }
    
    public void addProduct(String product, int price, int stock){
        this.productAndPrice.put(product, price);
        this.productAndStock.put(product, stock);
    }
    
    public int price(String product){
        return this.productAndPrice.getOrDefault(product, -99);
    }
    
    public int stock(String product){
        return this.productAndStock.getOrDefault(product, 0);
    }
    
    public boolean take(String product){
        if(!this.productAndStock.containsKey(product) || this.productAndStock.get(product) == 0){
            return false;
        }
        
        this.productAndStock.put(product, this.productAndStock.get(product) - 1);
        return true;
    }
    
    public Set<String> products(){
        return this.productAndPrice.keySet();
    }
}
