/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ro.utcluj.isp.elevator.app;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mihai.hulea
 */
public class Elevator extends Observable implements Runnable,IElevator{
    
    private HashSet<Command> queue = new HashSet<>();
    private ElevatorState state;
    private int currentFloor;
    private Command currentCommand;

    public Elevator() {
        state = ElevatorState.WAIT_COMMAND;
        currentFloor = 0;
    }
    
    
    @Override
    public void run() {
        while(true){
            if(state == ElevatorState.WAIT_COMMAND){
                System.out.println("Execute command.");
                if(!queue.isEmpty()){
                    Command c = queue.iterator().next();
                    queue.remove(c);
                    setChanged();
                    notifyObservers();
                    if(c.getFloor()<currentFloor){
                        state = ElevatorState.GO_DOWN;
                        System.out.println("GO DOWN");
                    }
                    else if(c.getFloor()>currentFloor){
                        state = ElevatorState.GO_UP;
                        System.out.println("GO UP");
                    }
                    currentCommand = c;
                }else{
                    if(currentCommand==null)
                        synchronized(this){
                            try {
                                wait();
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Elevator.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                }
            }//.end WAIT_COMMAND
            
            if(state == ElevatorState.GO_UP){
                System.out.println("Elevator is going up...");
                try {
                    Thread.sleep(1000*currentCommand.getFloor()-currentFloor);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Elevator.class.getName()).log(Level.SEVERE, null, ex);
                }
                currentFloor = currentCommand.getFloor();
            }
            
            if(currentCommand!=null && currentFloor == currentCommand.getFloor()){
                setChanged();
                notifyObservers();
                System.out.println("OPEN DOORS");
                System.out.println("CLOSE DOORS");
                currentCommand = null;
                state = ElevatorState.WAIT_COMMAND;
            }
            
        }
    }

    @Override
    public void sendCommand(Command c) {
        synchronized(this){
            System.out.println("Add new command...");
            queue.add(c);
            notify();
        }
    }
    
    public static void main(String[] args) {
        Elevator e = new Elevator();
        ElevatorUI ui = new ElevatorUI(e);
        e.addObserver(ui);
        Thread t = new Thread(e);
        t.start();
        ui.setVisible(true);
    }
}
