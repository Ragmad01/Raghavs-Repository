/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ship;

/**
 *
 * @author venra
 */
public class Ship {
private String shipType;
private double topSpeed;
private double currentSpeed;
private int maxHullStrength;
private int currentHullStrength;
private int weaponStrength;
private int mass;
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public Ship(String type, double speed, int hStrength, int wStrength, int totalMass){
        shipType = type;
        topSpeed = speed;
        currentSpeed = 0;
        maxHullStrength = hStrength;
        currentHullStrength = hStrength;
        weaponStrength = wStrength;
        mass = totalMass;
    }
    
    //accessor
    public String getShipType(){
        return shipType;
    }
    
    //mutator
    public void setShipType(String type){
        this.shipType = type;
    }
    //set current speed and make sure that current speed is never over the top speed
    public void setCurrentSpeed(double speed){
        currentSpeed = speed;
        if(currentSpeed > topSpeed){
            currentSpeed = topSpeed;
        }
        
    }
    //toString Method
    public String toString(){
        return"Type: " + shipType + "/ntopSpeed: " + topSpeed; 
    }
    
}
