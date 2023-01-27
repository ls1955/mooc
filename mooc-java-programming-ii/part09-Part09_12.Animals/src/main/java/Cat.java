/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cheong
 */
public class Cat extends Animal implements NoiseCapable{
    private String name;
    
    public Cat(String name){
        super(name);
    }
    
    public Cat(){
        this("Cat");
    }
    
    public void purr(){
        System.out.println(getName() + " purrs");
    }

    @Override
    public void makeNoise(){
        this.purr();
    }
}
