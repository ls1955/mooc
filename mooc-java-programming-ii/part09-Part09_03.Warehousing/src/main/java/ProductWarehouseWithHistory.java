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

public class ProductWarehouseWithHistory extends ProductWarehouse{
    private ChangeHistory histories;
    
    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance){
        super(productName, capacity);
        super.addToWarehouse(initialBalance);
        this.histories = new ChangeHistory();
        this.histories.add(initialBalance);
    }
    
    @Override
    public void addToWarehouse(double amount){
        super.addToWarehouse(amount);
        this.histories.add(super.getBalance());
    }
    
    @Override
    public double takeFromWarehouse(double amount){
        double takenAmount = super.takeFromWarehouse(amount);
        this.histories.add(super.getBalance());
        
        return takenAmount;
    }
    
    public String history(){
        return this.histories.toString();
    }
    
    public void printAnalysis(){
        System.out.println("Product: " + super.getName());
        System.out.println("History: " + this.history());
        System.out.println("Largest amount of product: " + this.histories.maxValue());
        System.out.println("Smallest amount of product: " + this.histories.minValue());
        System.out.println("Average: " + this.histories.average());
    }
}
