package org.cventbootcamp.repository;

import org.cventbootcamp.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepository {
    @Autowired
    private DataSource dataSource;

    public List<Vehicle> getAllVehicles(){
        String query = "SELECT * FROM vehicles";
        List<Vehicle> vehicles = new ArrayList<>();

        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery()){

            while(rs.next()){
                vehicles.add(mapRowToVehicle(rs));
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByPriceRange(double minPrice, double maxPrice) throws SQLException {
        String query = "SELECT * FROM vehicles WHERE price >= ? AND price <= ?";
        List<Vehicle> vehicles = new ArrayList<>();

        try (Connection conn = dataSource.getConnection()) {
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setDouble(1, minPrice);
                ps.setDouble(2, maxPrice);

                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        vehicles.add(mapRowToVehicle(rs));
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                return vehicles;
            }
        }
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model) throws SQLException {
        String query = "SELECT * FROM vehicles WHERE make = ? AND model <= ?";
        List<Vehicle> vehicles = new ArrayList<>();

        try (Connection conn = dataSource.getConnection()) {
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setString(1, make);
                ps.setString(2, model);

                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        vehicles.add(mapRowToVehicle(rs));
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                return vehicles;
            }
        }
    }

    private Vehicle mapRowToVehicle(ResultSet rs) throws SQLException {
        int vehicleId = rs.getInt("vehicle_id");
        String vin = rs.getString("vin");
        String make = rs.getString("make");
        String model = rs.getString("model");
        String color = rs.getString("color");
        int mileage = rs.getInt("mileage");
        String type = rs.getString("type");
        Double price = rs.getDouble("price");
        int year = rs.getInt("year");
        Boolean sold = rs.getBoolean("sold");
        return new Vehicle(vehicleId, vin, make, model, color, mileage, type, price, year, sold);
    }
}
