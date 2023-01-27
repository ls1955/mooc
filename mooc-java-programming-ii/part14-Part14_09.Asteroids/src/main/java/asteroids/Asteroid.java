/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asteroids;

import java.util.Random;
import javafx.scene.shape.Polygon;

/**
 *
 * @author cheong
 */
public class Asteroid extends Character {
    private double rotationalMovement;
    
    public Asteroid(int x, int y) {
        super(new PolygonFactory().createPolygon(), x, y);
        
        Random rng = new Random();
        
        super.getShape().setRotate(rng.nextInt(360));
        int accelerationAmount = 1 + rng.nextInt(10);
        for (int i = 0; i < accelerationAmount; i++) {
            accelerate();
        }
        
        this.rotationalMovement = 0.5 - rng.nextDouble();
    }
    
    @Override
    public void move() {
        super.move();
        super.getShape().setRotate(super.getShape().getRotate() + this.rotationalMovement);
    }
}
