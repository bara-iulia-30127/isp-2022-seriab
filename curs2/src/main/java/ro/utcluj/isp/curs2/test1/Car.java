package ro.utcluj.isp.curs2.test1;

import java.util.Objects;


public class Car {
    private String plateNumber;
    private String model;
    private boolean started;

    public Car(String plateNumber, String model, boolean started) {
        this.plateNumber = plateNumber;
        this.model = model;
        this.started = started;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public String getModel() {
        return model;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.plateNumber);
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
        final Car other = (Car) obj;
        return Objects.equals(this.plateNumber, other.plateNumber);
    }

    @Override
    public String toString() {
        return "Car{" + "plateNumber=" + plateNumber + ", model=" + model + ", started=" + started + '}';
    }
    
    
    
    
}
