package org.cventbootcamp;
import org.cventbootcamp.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.cventbootcamp.repository.VehicleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class Main implements CommandLineRunner {
    @Autowired
    private VehicleRepository vehicleRepository;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        List<Vehicle> vehicleList = vehicleRepository.getAllVehicles();
        System.out.println("List of All Vehicles: ");
        vehicleList.forEach(System.out::println);

        System.out.println("Select a Method to Sort the Vehicles: ");
        System.out.println("1. By Price Range ");
        System.out.println("2. By Make/Model ");
        System.out.println("3. By Year Range ");
        System.out.println("4. By Color ");
        System.out.println("5. By Mileage Range ");
        System.out.println("6. By Type");

        int userInput = scanner.nextInt();

        switch (userInput) {
            case 1:
                System.out.println("Enter a Min Price: ");
                double minPrice = scanner.nextDouble();
                System.out.println("Enter a Max Price: ");
                double maxPrice = scanner.nextDouble();
                List<Vehicle> vehicleListPrice = vehicleRepository.getVehiclesByPriceRange(minPrice, maxPrice);
                vehicleListPrice.forEach(System.out::println);
                break;
        }
        scanner.close();
    }
}