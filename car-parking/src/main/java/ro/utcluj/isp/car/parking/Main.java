/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ro.utcluj.isp.car.parking;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mihai.hulea
 */
public class Main {
    public static void main(String[] args) {
        CarParkingController cpc = new CarParkingController();
        cpc.entryCar("CJ01AAA");
        cpc.entryCar("CJ02AAA");
        cpc.entryCar("CJ03AAA");
        cpc.entryCar("CJ04AAA");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        cpc.exitCar("CJ03AAA");
        
    }
}
