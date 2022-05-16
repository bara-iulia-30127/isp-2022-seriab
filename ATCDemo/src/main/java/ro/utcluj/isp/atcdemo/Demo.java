/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ro.utcluj.isp.atcdemo;

import java.util.logging.Level;
import java.util.logging.Logger;

class AtcCommand{
    
}

class TakeOff extends AtcCommand{
    private int altitude;

    public TakeOff(int altitude) {
        this.altitude = altitude;
    }

    public int getAltitude() {
        return altitude;
    }
    
}

class Land extends AtcCommand{
    
}

enum State{
    ON_STAND,TAXIING, TAKING_OFF, ASCENDING, CRUISING, DESCENDING, LANDED;
}

class Aircraft  implements Runnable{
    
    private int cruiseAltitude;
    private boolean active = true;
    private State currentSate;
    private AtcCommand rcvdCmd;
    
    public void run(){
        currentSate = State.ON_STAND;
        displayState();
        while(currentSate!=State.LANDED){
            if(currentSate==State.ON_STAND){
                synchronized (this) {
                    try{wait();}catch(Exception e){e.printStackTrace();}
                    currentSate = State.TAXIING;
                }
            }
            if(currentSate==State.TAXIING){
                displayState();
                sleep(10);
                currentSate = State.TAKING_OFF;
            }
            if(currentSate==State.TAKING_OFF){
                displayState();
                sleep(10);
                currentSate = State.ASCENDING;
            }
            if(currentSate==State.ASCENDING){
                displayState();
                sleep(10*cruiseAltitude);
                currentSate = State.CRUISING;
            }
            if(currentSate==State.CRUISING){
                displayState();
                synchronized (this) {
                    try{wait();}catch(Exception e){}
                }
                if(rcvdCmd instanceof Land)
                    currentSate = State.DESCENDING;
            }
            if(currentSate==State.DESCENDING){
                displayState();
                sleep(5);
                currentSate = State.LANDED;
            }
            
        }//.while
        displayState();
    }
    
    void sleep(int t){
        try {
            Thread.sleep(t*200);
        } catch (InterruptedException ex) {
            Logger.getLogger(Aircraft.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void displayState(){
        System.out.println("Aircraft on state "+currentSate);
    }
    
    void executeCommand(AtcCommand com){
        rcvdCmd = com;
        if(com instanceof TakeOff){
            System.out.println("RCV TAKEOFF COMMAND");
            synchronized (this){
                cruiseAltitude = ((TakeOff) com).getAltitude();
                notify();
            }
        
        }else if(com instanceof Land){
            System.out.println("RCV LAND COMMAND");
            synchronized (this){
                notify();
            }
        }
    }
}

/**
 *
 * @author mihai.hulea
 */
public class Demo {
    
}
