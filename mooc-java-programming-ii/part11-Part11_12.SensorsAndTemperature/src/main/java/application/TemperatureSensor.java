/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

/**
 *
 * @author cheong
 */

import java.util.Random;

public class TemperatureSensor implements Sensor {
    private boolean isRunning;

    public TemperatureSensor() {
        this.isRunning = false;
    }

    @Override
    public boolean isOn() {
        return this.isRunning;
    }

    @Override
    public void setOn() {
        this.isRunning = true;
    }

    @Override
    public void setOff() {
        this.isRunning = false;
    }

    @Override
    public int read() {
        if(!this.isRunning) {
            throw new IllegalArgumentException("The sensor is not running.");
        }
        
        return new Random().nextInt(61) - 30;
    }
    
}
