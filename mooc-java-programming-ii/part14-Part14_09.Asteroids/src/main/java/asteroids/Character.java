/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asteroids;

import javafx.geometry.Point2D;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

/**
 *
 * @author cheong
 */
public class Character {
    private Polygon shape;
    private Point2D moveDirection;
    boolean alive;
    
    public Character(Polygon polygon, int x, int y) {
        this.shape = polygon;
        this.shape.setTranslateX(x);
        this.shape.setTranslateY(y);
        this.moveDirection = new Point2D(0, 0);
        this.alive = true;
    }
    
    public void accelerate() {
        double changeInX = Math.cos(Math.toRadians(this.shape.getRotate()));
        double changeInY = Math.sin(Math.toRadians(this.shape.getRotate()));
        
        changeInX *= 0.05;
        changeInY *= 0.05;
        
        this.moveDirection = this.moveDirection.add(changeInX, changeInY);
    }
    
    public boolean hasCollide(Character other) {
        Shape collisionArea = Shape.intersect(this.shape, other.shape);
        return collisionArea.getBoundsInLocal().getWidth() != -1;
    }

    public Point2D getMoveDirection() {
        return moveDirection;
    }

    public void setMoveDirection(Point2D moveDirection) {
        this.moveDirection = moveDirection;
    }
    
    public Polygon getShape() {
        return shape;
    }    
    
    public boolean isAlive() {
        return this.alive;
    }
    
    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    
    public void move() {
        this.shape.setTranslateX(this.shape.getTranslateX() + this.moveDirection.getX());
        this.shape.setTranslateY(this.shape.getTranslateY() + this.moveDirection.getY());
        
        if (this.shape.getTranslateX() < 0) {
            this.shape.setTranslateX(this.shape.getTranslateX() + AsteroidsApplication.WINDOWWIDTH);
        } else if (this.shape.getTranslateX() > AsteroidsApplication.WINDOWWIDTH) {
            this.shape.setTranslateX(this.shape.getTranslateX() % AsteroidsApplication.WINDOWWIDTH);
        }
        
        if (this.shape.getTranslateY() < 0) {
            this.shape.setTranslateY(this.shape.getTranslateY() + AsteroidsApplication.WINDOWHEIGHT);
        } else if (this.shape.getTranslateY() > AsteroidsApplication.WINDOWHEIGHT) {
            this.shape.setTranslateY(this.shape.getTranslateY() % AsteroidsApplication.WINDOWHEIGHT);
        }
    }
    
    public void turnLeft() {
        this.shape.setRotate(this.shape.getRotate() - 5);
    }
    
    public void turnRight() {
        this.shape.setRotate(this.shape.getRotate() + 5);
    }
}
