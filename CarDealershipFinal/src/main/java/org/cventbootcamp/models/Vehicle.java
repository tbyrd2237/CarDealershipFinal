package org.cventbootcamp.models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Vehicle {
    private int vehicle_id;
    private String VIN;
    private String make;
    private String model;
    private String color;
    private int mileage;
    private String type;
    private double price;
    private int year;
    private Boolean sold;
}
