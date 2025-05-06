package com.OOP.OOP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShipmentManager {

    // Method to add a new shipment
    public void addShipment(shipment shipment) {
        try (Connection conn = DatabaseConnection.connect()) {
            String sql = "INSERT INTO shipments (sender, receiver, contents, delivery_status) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, shipment.getSender());
                pstmt.setString(2, shipment.getReceiver());
                pstmt.setString(3, shipment.getContents());
                pstmt.setString(4, shipment.getDeliveryStatus());
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to update an existing shipment
    public void updateShipment(shipment shipment) {
        try (Connection conn = DatabaseConnection.connect()) {
            String sql = "UPDATE shipments SET sender = ?, receiver = ?, contents = ?, delivery_status = ? WHERE id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, shipment.getSender());
                pstmt.setString(2, shipment.getReceiver());
                pstmt.setString(3, shipment.getContents());
                pstmt.setString(4, shipment.getDeliveryStatus());
                pstmt.setInt(5, shipment.getId());
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to delete a shipment by ID
    public void deleteShipment(int id) {
        try (Connection conn = DatabaseConnection.connect()) {
            String sql = "DELETE FROM shipments WHERE id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, id);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to retrieve all shipments
    public List<shipment> getAllShipments() {
        List<shipment> shipments = new ArrayList<>();
        try (Connection conn = DatabaseConnection.connect()) {
            String sql = "SELECT * FROM shipments";
            try (PreparedStatement pstmt = conn.prepareStatement(sql);
                 ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String sender = rs.getString("sender");
                    String receiver = rs.getString("receiver");
                    String contents = rs.getString("contents");
                    String deliveryStatus = rs.getString("delivery_status");
                    shipments.add(new shipment(id, sender, receiver, contents, deliveryStatus));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shipments;
    }
}
