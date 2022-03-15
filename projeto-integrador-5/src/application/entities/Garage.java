package application.entities;

import java.util.ArrayList;
import java.util.List;

public class Garage {

    private Integer id = 1;
    private List<Vehicle> vehicles = new ArrayList<>();

    public Garage() {
        this.id++;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }

    @Override
    public String toString() {
        return "Garage{" +
                "id=" + id +
                ", vehicles=" + vehicles +
                '}';
    }
}
