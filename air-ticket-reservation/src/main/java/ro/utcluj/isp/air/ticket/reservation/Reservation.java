/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ro.utcluj.isp.air.ticket.reservation;

/**
 *
 * @author mihai.hulea
 */
public class Reservation implements Comparable<Reservation>{
    private String reservationNumber;
    private String flightNumber;
    private int noTickets;

    public Reservation(String reservationBumber, String flightNumber, int noTickets) {
        this.reservationNumber = reservationBumber;
        this.flightNumber = flightNumber;
        this.noTickets = noTickets;
    }

    public String getReservationBumber() {
        return reservationNumber;
    }

    public void setReservationBumber(String reservationBumber) {
        this.reservationNumber = reservationBumber;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getNoTickets() {
        return noTickets;
    }

    public void setNoTickets(int noTickets) {
        this.noTickets = noTickets;
    }

    @Override
    public int compareTo(Reservation arg0) {
        return this.flightNumber.compareTo(arg0.flightNumber);
       // return this.noTickets-arg0.noTickets;
    }
    
//    @Override
//    public int compareTo(Reservation arg0) {
//        return this.getNoTickets()-arg0.getNoTickets();
//    }

    @Override
    public String toString() {
        return "Reservation{" + "reservationNumber=" + reservationNumber + ", flightNumber=" + flightNumber + ", noTickets=" + noTickets + '}';
    }
    
    
}
