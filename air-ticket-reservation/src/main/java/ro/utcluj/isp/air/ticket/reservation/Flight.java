/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ro.utcluj.isp.air.ticket.reservation;

import java.util.Objects;

/**
 *
 * @author mihai.hulea
 */
public class Flight {
    String flightNumber;
    String departure;
    String destinatino;
    int availableTikets;
    double price;

    public Flight(String flightNumber, String departure, String destinatino, int availableTikets, double price) {
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.destinatino = destinatino;
        this.availableTikets = availableTikets;
        this.price = price;
    }
    
    

    public void setAvailableTikets(int availableTikets) {
        this.availableTikets = availableTikets;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDeparture() {
        return departure;
    }

    public String getDestinatino() {
        return destinatino;
    }

    public int getAvailableTikets() {
        return availableTikets;
    }

    public double getPrice() {
        return price;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Flight other = (Flight) obj;
        return Objects.equals(this.flightNumber, other.flightNumber);
    }

    @Override
    public String toString() {
        return "Flight{" + "flightNumber=" + flightNumber + ", departure=" + departure + ", destinatino=" + destinatino + ", availableTikets=" + availableTikets + ", price=" + price + '}';
    }
    
    
            
}
