/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ro.utcluj.isp.carcontrol;

import java.util.Observable;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mihai.hulea
 */

enum Status{
    RUNNING, STOPPED;
}

public class Car extends Observable implements Runnable{
    private boolean active; 
    private int distance;
    private Status status;
    private String plateNumber;

    public Car(String plateNumber) {
        this.plateNumber = plateNumber;
        active = true;
        status = Status.STOPPED;
    }
    
    @Override
    public void run() {
        while(active){
            if(status == Status.STOPPED){
                synchronized(this){
                    try {
                        System.out.println("Car si stoped");
                        this.wait();
                        status = Status.RUNNING;
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }//sync
            }//.if
            
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            distance++;
            System.out.println("Car is moving. Traveled distance = "+distance+" km");
            //notify UI that this car status has changed
            this.setChanged();
            this.notifyObservers();
        }
    }//.run
    
    public  void stopCar(){
        status = Status.STOPPED;
    }
    
    public void startCar(){
        synchronized(this){
          this.notify();
        }
    }

    public Status getStatus() {
        return status;
    }    

    public String getPlateNumber() {
        return plateNumber;
    }

    public int getDistance() {
        return distance;
    }
        
    
}
