package application;

import application.entities.Garage;
import application.entities.Vehicle;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(new Vehicle("Ford", "Fiesta", BigDecimal.valueOf(1000)));
        vehicleList.add(new Vehicle("Ford", "Focus", BigDecimal.valueOf(1200)));
        vehicleList.add(new Vehicle("Ford", "Explorer", BigDecimal.valueOf(2500)));
        vehicleList.add(new Vehicle("Fiat", "Uno", BigDecimal.valueOf(500)));
        vehicleList.add(new Vehicle("Fiat", "Cronos", BigDecimal.valueOf(1000)));
        vehicleList.add(new Vehicle("Fiat", "Torino", BigDecimal.valueOf(1250)));
        vehicleList.add(new Vehicle("Chevrolet", "Aveo", BigDecimal.valueOf(1250)));
        vehicleList.add(new Vehicle("Chevrolet", "Spin", BigDecimal.valueOf(2500)));
        vehicleList.add(new Vehicle("Toyota", "Corola", BigDecimal.valueOf(1200)));
        vehicleList.add(new Vehicle("Toyota", "Fortuner", BigDecimal.valueOf(3000)));
        vehicleList.add(new Vehicle("Renault", "Logan", BigDecimal.valueOf(950)));

        Garage garage = new Garage();
        for (Vehicle vehicle : vehicleList) {
            garage.addVehicle(vehicle);
        }

        garage.getVehicles().sort(Comparator.comparing(Vehicle::getPrice));

        System.out.println("Vehicles sorted by price: ");
        garage.getVehicles().forEach(System.out::println);
        System.out.println("---------------------------");

        garage.getVehicles().sort(Comparator.comparing(Vehicle::getBrand));

        System.out.println("Vehicles sorted by brand: ");
        garage.getVehicles().forEach(System.out::println);
        System.out.println("---------------------------");

        List<Vehicle> vehiclesUnderThousand = garage.getVehicles().stream().filter(vehicle -> (vehicle.getPrice().compareTo(BigDecimal
                .valueOf(1000)) < 0)).collect(Collectors.toList());

        System.out.println("Vehicles less than a thousand: ");
        System.out.println(vehiclesUnderThousand);
        System.out.println("---------------------------");

        List<Vehicle> vehiclesBetweenThousand = garage.getVehicles().stream().filter(vehicle -> vehicle.getPrice().compareTo(
                BigDecimal.valueOf(1000)) >= 0).collect(Collectors.toList());

        System.out.println("Vehicles greater than or equal to one thousand: ");
        System.out.println(vehiclesBetweenThousand);
        System.out.println("---------------------------");

        OptionalDouble averageValueOfVehicles = garage.getVehicles().stream()
                .map(vehicle -> vehicle.getPrice())
                .mapToDouble(x -> x.doubleValue())
                .average();

        System.out.println("Average value of vehicles: " + averageValueOfVehicles);


    }
}
