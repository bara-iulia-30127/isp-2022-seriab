/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ro.utcluj.isp.air.ticket.reservation;

import java.util.Comparator;

/**
 *
 * @author mihai.hulea
 */
public class Demo {
    public static void main(String[] args) {
        FlightsRepository flightRepo = new FlightsRepository();
        ReservationManager rm = new ReservationManager(flightRepo);
        
        flightRepo.addFlight("ABG5", "CJ", "BU", 100, 50);
        flightRepo.addFlight("GSFD", "CJ", "BU", 100, 50);
        flightRepo.addFlight("RST", "CJ", "BU", 100, 50);
        flightRepo.addFlight("TSR", "CJ", "BU", 100, 50);
        flightRepo.addFlight("YTS", "CJ", "BU", 100, 50);
        
        
        rm.listFlights();
        
        rm.makeReservation("ABG5", 6);
        rm.makeReservation("TSR", 2);
        rm.makeReservation("YTS", 3);
        rm.makeReservation("GSFD", 3);
        
        rm.listReservations();
        rm.listReservationsSorted();
        rm.listReservationsSortByCriteria(new Comparator<Reservation>(){
            @Override
            public int compare(Reservation arg0, Reservation arg1) {
                return arg0.getNoTickets()-arg1.getNoTickets();
            }
        });
        
        rm.listReservationsSortByCriteria(new TicketSOrtComparator());
        
    }
   
}

class TicketSOrtComparator implements Comparator<Reservation>{

    @Override
    public int compare(Reservation arg0, Reservation arg1) {
        return arg0.getNoTickets()-arg1.getNoTickets();
    }
    
}

