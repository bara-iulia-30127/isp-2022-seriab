/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ro.utcluj.isp.air.ticket.reservation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author mihai.hulea
 */
public class FlightsRepository {
    
    HashMap<String,Flight> flights = new HashMap<>();
    
    void addFlight(String flightNumber, String departure, String destinatino, int noTickets, int price){
       Flight f = new Flight(flightNumber, departure, destinatino, noTickets, price);
       flights.put(f.getFlightNumber(), f);
    }
    
    Flight getFlightByFlightNumber(String flightNumber){
        return flights.get(flightNumber);
    }
    
    List<String> getAllFlightsInfo(){
        ArrayList<String> list = new ArrayList<>();
        for(Flight f:flights.values()){
            list.add(f.getFlightNumber()+" "+f.getDeparture()+" "+f.getDestinatino());
        }
        return list;
    }
}
