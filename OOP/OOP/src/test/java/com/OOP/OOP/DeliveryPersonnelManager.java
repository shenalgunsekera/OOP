package com.OOP.OOP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeliveryPersonnelManager {

    // Method to add a new delivery personnel
    public void addDeliveryPersonnel(DeliveryPersonnel personnel) {
        try (Connection conn = DatabaseConnection.connect()) {
            String sql = "INSERT INTO delivery_personnel (name, schedule, assigned_routes, delivery_history) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, personnel.getName());
                pstmt.setString(2, personnel.getSchedule());
                pstmt.setString(3, personnel.getAssignedRoutes());
                pstmt.setString(4, personnel.getDeliveryHistory());
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to update an existing delivery personnel
    public void updateDeliveryPersonnel(DeliveryPersonnel personnel) {
        try (Connection conn = DatabaseConnection.connect()) {
            String sql = "UPDATE delivery_personnel SET name = ?, schedule = ?, assigned_routes = ?, delivery_history = ? WHERE id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, personnel.getName());
                pstmt.setString(2, personnel.getSchedule());
                pstmt.setString(3, personnel.getAssignedRoutes());
                pstmt.setString(4, personnel.getDeliveryHistory());
                pstmt.setInt(5, personnel.getId());
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to delete delivery personnel by ID
    public void deleteDeliveryPersonnel(int id) {
        try (Connection conn = DatabaseConnection.connect()) {
            String sql = "DELETE FROM delivery_personnel WHERE id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, id);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to retrieve all delivery personnel
    public List<DeliveryPersonnel> getAllDeliveryPersonnel() {
        List<DeliveryPersonnel> personnelList = new ArrayList<>();
        try (Connection conn = DatabaseConnection.connect()) {
            String sql = "SELECT * FROM delivery_personnel";
            try (PreparedStatement pstmt = conn.prepareStatement(sql);
                 ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String schedule = rs.getString("schedule");
                    String assignedRoutes = rs.getString("assigned_routes");
                    String deliveryHistory = rs.getString("delivery_history");
                    personnelList.add(new DeliveryPersonnel(id, name, schedule, assignedRoutes, deliveryHistory));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personnelList;
    }
}
