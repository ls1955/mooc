/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cheong
 */

import java.util.Collection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class VehicleRegistry {
    private HashMap<LicensePlate, String> registries;
    
    public VehicleRegistry(){
        this.registries = new HashMap<>();
    }
    
    public boolean add(LicensePlate licensePlate, String owner){
        if(this.registries.containsKey(licensePlate)){
            return false;
        }
        
        this.registries.put(licensePlate, owner);
        return true;
    }
    
    public String get(LicensePlate licensePlate){
        return this.registries.get(licensePlate);
    }
    
    public boolean remove(LicensePlate licensePlate){
        if(!(this.registries.containsKey(licensePlate))){
            return false;
        }
        
        this.registries.remove(licensePlate);
        return true;
    }
    
    public void printLicensePlates(){
         for(LicensePlate licensePlate: this.registries.keySet()){
             System.out.println(licensePlate);
         }
    }
    
    public void printOwners(){
        ArrayList<String> ownersTally = new ArrayList<>();
        
        for(String owner: this.registries.values()){
            if(ownersTally.contains(owner)){
                continue;
            }
            
            ownersTally.add(owner);
            System.out.println(owner);
        }
    }
}
