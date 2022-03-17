/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ro.utcluj.isp.air.ticket.reservation;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

/**
 *
 * @author mihai.hulea
 */
public class ReservationManager {
    
    private ArrayList<Reservation> list = new ArrayList<>();    
    private FlightsRepository repo;

    public ReservationManager(FlightsRepository repo) {
        this.repo = repo;
    }
    
    Reservation makeReservation(String flightNumber, int noTickets){
        Flight f = repo.getFlightByFlightNumber(flightNumber);
        if(f!=null){
            f.setAvailableTikets(f.getAvailableTikets()-noTickets);
            Reservation r = new Reservation("",f.getFlightNumber(),noTickets);
            list.add(r);
            return r;
        }else{
            return null;
        }
    }
    
    void listFlights(){
        System.out.println("List all flights:");
        for(String s:repo.getAllFlightsInfo()){
            System.out.println(s); 
       }
    }
    
    void listReservations(){
        System.out.println("List reservations:");
        for(Reservation r: list)
            System.out.println(r);
    }
    
    void listReservationsSorted(){
        Collections.sort(list);
        listReservations();
    }
    
    void listReservationsSortByCriteria(Comparator<Reservation> comparator){
        list.sort(comparator);
        listReservations();
    }
    
}
