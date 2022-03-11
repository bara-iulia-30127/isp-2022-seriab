/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ro.utcluj.isp.car.parking;

public interface ICarParking {
    void entryCar(String plateNumber);
    long exitCar(String plateNumber);
}
