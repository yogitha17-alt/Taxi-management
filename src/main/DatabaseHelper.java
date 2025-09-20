package main;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseHelper {
    private static final String URL = "jdbc:mysql://localhost:3306/vehicledb";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static ArrayList<Vehicle> fetchVehicle() {
        ArrayList<Vehicle> vehicle = new ArrayList<>();

        String sql = "SELECT * FROM vehicle";

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("vehicleid");
                String make = rs.getString("make");
                String model = rs.getString("model");
                int year = rs.getInt("year");
                String reg = rs.getString("reg_num");
                String type = rs.getString("type");
                if (type.equals("Car")) {
                    vehicle.add(fetchcar(conn, id, make, model, year, reg));
                } else if (type.equals("Motorbike")) {
                    vehicle.add(fetchMotorbike(conn, id, make, model, year, reg));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            // e.printStackTrace();
        }
        return vehicle;
    }

    private static Car fetchcar(Connection conn, int id, String make, String model, int year, String reg) throws SQLException {
        String sql = "SELECT num_doors, category, battery_range, fuel_type FROM car WHERE vehicleid = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int doors = rs.getInt("num_doors");
                    String category = rs.getString("category");
                    int miles = rs.getInt("battery_range");
                    String fuel_type = rs.getString("fuel_type");

                    if (category.equals("Electric")) {
                        System.out.println("Creating Vehicles...");// helps developer see whats happening - take out in
                                                                  // live version
                        return new Electriccar(make, model, year, reg, doors, miles);
                    } else {
                        return new Nonelectriccar(make, model, year, reg, doors, fuel_type);
                    }
                }
            }
        }
        return null;
    }

    private static Motorbike fetchMotorbike(Connection conn, int id, String make, String model, int year, String reg)
            throws SQLException {
        String sql = "SELECT has_sidecar FROM motorbike WHERE vehicleid = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    boolean sidecar = rs.getBoolean("has_sidecar");
                    return new Motorbike(make, model, year, reg, sidecar);
                }
            }
        }
        return null;
    }
}


