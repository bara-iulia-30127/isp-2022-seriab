/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ro.utcluj.isp.car.parking;

public class CarParkingController implements ICarParking{
    
    private CarEntry[] cars = new CarEntry[20];
    
    @Override
    public void entryCar(String plateNumber) {
        CarEntry car = new CarEntry(plateNumber);
        for(int i=0;i<cars.length;i++){
            if(cars[i]==null){
                car.setEntryTime(System.currentTimeMillis());
                cars[i] = car;
                System.out.println("Car has been parked ->"+car);
                return;
            }
        }
        System.out.println("No parking place available!");
    }

    @Override
    public long exitCar(String plateNumber) {
       for(int i=0;i<cars.length;i++){
           if(cars[i]!=null&&cars[i].getPlateNumber().equals(plateNumber)){
               cars[i].setExitTime(System.currentTimeMillis());
               long cost = calculateParkingCost(cars[i]);
               System.out.println("Car exit parking -> "+cars[i]);
               cars[i] = null;
               return cost;
           }
       } 
        System.out.println("No car found in parking with plate number "+plateNumber);
        return -1;
    }
    
    
    private long calculateParkingCost(CarEntry entry){
        return (entry.getExitTime()-entry.getEntryTime())*2;
    }
}
