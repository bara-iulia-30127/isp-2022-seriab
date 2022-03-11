
package ro.utcluj.isp.car.parking;

import java.util.Objects;

public class CarEntry {
    private String plateNumber;    
    private long entryTime;
    private long exitTime;

    public CarEntry(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public void setEntryTime(long entryTime) {
        this.entryTime = entryTime;
    }

    public void setExitTime(long exitTime) {
        this.exitTime = exitTime;
    }
    
    public String getPlateNumber() {
        return plateNumber;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public long getExitTime() {
        return exitTime;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.plateNumber);
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
        final CarEntry other = (CarEntry) obj;
        return Objects.equals(this.plateNumber, other.plateNumber);
    }

    

    @Override
    public String toString() {
        return "CarEntry{" + "plateNumber=" + plateNumber + ", entryTime=" + entryTime + ", exitTime=" + exitTime + '}';
    }
}
