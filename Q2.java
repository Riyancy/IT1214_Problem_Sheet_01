import java.util.*;

class Vehicle {
    private String licensePlate;
    private String ownerName;
    private int hoursParked;
    
    public Vehicle(String licensePlate, String ownerName, int hoursParked) {
        this.licensePlate = licensePlate;
        this.ownerName = ownerName;
        this.hoursParked = hoursParked;
    }
    
    String getLicensePlate() {
        return licensePlate;
    }
    
    void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
    
    String getOwnerName() {
        return ownerName;
    }
    
    void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    
    int getHoursParked() {
        return hoursParked;
    }
    
    void setHoursParked(int hoursParked) {
        this.hoursParked = hoursParked;
    }
}

class ParkingLot {
    private Vehicle[] vehicles;  
    private int count;
    
    public ParkingLot() {
        vehicles = new Vehicle[5]; 
        count = 0;
    }
    
    void addVehicle(Vehicle v) {
        if (count < vehicles.length) {
          
            for (int i = 0; i < count; i++) {
                if (vehicles[i].getLicensePlate().equals(v.getLicensePlate())) {
                    System.out.println("Vehicle with license plate " + v.getLicensePlate() + " already exists.");
                    return;
                }
            }
            vehicles[count++] = v;
            System.out.println("Vehicle added successfully.");
        } else {
            System.out.println("Parking lot is full. Cannot add more vehicles.");
        }
    }
    
    void removeVehicle(String licensePlate) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (vehicles[i].getLicensePlate().equals(licensePlate)) {
               
                for (int j = i; j < count - 1; j++) {
                    vehicles[j] = vehicles[j + 1];
                }
                vehicles[--count] = null;
                found = true;
                System.out.println("Vehicle with license plate " + licensePlate + " removed successfully.");
                break;
            }
        }
        if (!found) {
            System.out.println("Vehicle with license plate " + licensePlate + " not found.");
        }
    }
    
    void displayVehicles() {
        if (count == 0) {
            System.out.println("No vehicles currently parked.");
            return;
        }
        
        System.out.println("\nParking Lot Status:");
        System.out.println("------------------------------------------------");
        System.out.printf("%-15s %-20s %-15s%n", "License Plate", "Owner Name", "Hours Parked");
        System.out.println("------------------------------------------------");
        
        for (int i = 0; i < count; i++) {
            System.out.printf("%-15s %-20s %-15d%n",
                vehicles[i].getLicensePlate(),
                vehicles[i].getOwnerName(),
                vehicles[i].getHoursParked());
        }
        System.out.println("------------------------------------------------");
        System.out.println("Total vehicles parked: " + count + "/" + vehicles.length);
    }
    
    
    double calculateParkingFee(String licensePlate, double hourlyRate) {
        for (int i = 0; i < count; i++) {
            if (vehicles[i].getLicensePlate().equals(licensePlate)) {
                return vehicles[i].getHoursParked() * hourlyRate;
            }
        }
        System.out.println("Vehicle not found.");
        return -1;
    }
}

class Main {
    public static void main(String[] args) {
        ParkingLot pl = new ParkingLot();
        
       
        pl.addVehicle(new Vehicle("ABC123", "John Doe", 2));
        pl.addVehicle(new Vehicle("XYZ789", "Jane Smith", 4));
        pl.addVehicle(new Vehicle("LMN456", "Bob Brown", 1));
        
     
        pl.addVehicle(new Vehicle("ABC123", "Another Person", 3));
        
      
        pl.displayVehicles();
        
       
        pl.removeVehicle("XYZ789");
        
       
        pl.removeVehicle("NONEXIST");
        

        pl.displayVehicles();
        
       
        double fee = pl.calculateParkingFee("ABC123", 2.5);
        if (fee >= 0) {
            System.out.println("Parking fee for ABC123: $" + fee);
        }
    }
}