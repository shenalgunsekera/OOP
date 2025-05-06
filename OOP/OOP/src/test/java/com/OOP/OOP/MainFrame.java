package com.OOP.OOP;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainFrame extends JFrame {
    private ShipmentManager shipmentManager = new ShipmentManager();
    private DeliveryPersonnelManager personnelManager = new DeliveryPersonnelManager();

    public MainFrame() {
        setTitle("FastTrack Logistics");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create tabs for Shipments and Delivery Personnel
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Manage Shipments", createShipmentPanel());
        tabbedPane.addTab("Manage Delivery Personnel", createPersonnelPanel());

        add(tabbedPane, BorderLayout.CENTER);
    }

    private JPanel createShipmentPanel() {
        JPanel shipmentPanel = new JPanel();
        shipmentPanel.setLayout(new BorderLayout());

        // Shipment form
        JPanel formPanel = new JPanel(new GridLayout(5, 2));
        JTextField senderField = new JTextField();
        JTextField receiverField = new JTextField();
        JTextField contentsField = new JTextField();
        JTextField statusField = new JTextField("Pending"); // Default status

        formPanel.add(new JLabel("Sender:"));
        formPanel.add(senderField);
        formPanel.add(new JLabel("Receiver:"));
        formPanel.add(receiverField);
        formPanel.add(new JLabel("Contents:"));
        formPanel.add(contentsField);
        formPanel.add(new JLabel("Delivery Status:"));
        formPanel.add(statusField);

        JButton addShipmentButton = new JButton("Add Shipment");
        JButton updateShipmentButton = new JButton("Update Shipment");
        JButton deleteShipmentButton = new JButton("Delete Shipment");
        JButton viewShipmentsButton = new JButton("View Shipments");

        // Action listeners for shipment buttons
        addShipmentButton.addActionListener(e -> {
            shipment shipment = new shipment(0, senderField.getText(), receiverField.getText(), contentsField.getText(), statusField.getText());
            shipmentManager.addShipment(shipment);
            JOptionPane.showMessageDialog(this, "Shipment added successfully!");
            clearShipmentFields(senderField, receiverField, contentsField, statusField);
        });

        updateShipmentButton.addActionListener(e -> {
            // Logic to update a shipment (you may want to add a way to select a shipment to update)
            // For simplicity, this is left as a placeholder
            JOptionPane.showMessageDialog(this, "Update functionality not implemented yet.");
        });

        deleteShipmentButton.addActionListener(e -> {
            // Logic to delete a shipment (you may want to add a way to select a shipment to delete)
            // For simplicity, this is left as a placeholder
            JOptionPane.showMessageDialog(this, "Delete functionality not implemented yet.");
        });

        viewShipmentsButton.addActionListener(e -> {
            List<shipment> shipments = shipmentManager.getAllShipments();
            StringBuilder shipmentList = new StringBuilder("Shipments:\n");
            for (shipment shipment : shipments) {
                shipmentList.append("ID: ").append(shipment.getId())
                        .append(", Sender: ").append(shipment.getSender())
                        .append(", Receiver: ").append(shipment.getReceiver())
                        .append(", Contents: ").append(shipment.getContents())
                        .append(", Status: ").append(shipment.getDeliveryStatus()).append("\n");
            }
            JOptionPane.showMessageDialog(this, shipmentList.toString());
        });

        shipmentPanel.add(formPanel, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addShipmentButton);
        buttonPanel.add(updateShipmentButton);
        buttonPanel.add(deleteShipmentButton);
        buttonPanel.add(viewShipmentsButton);
        shipmentPanel.add(buttonPanel, BorderLayout.SOUTH);

        return shipmentPanel;
    }

    private JPanel createPersonnelPanel() {
        JPanel personnelPanel = new JPanel();
        personnelPanel.setLayout(new BorderLayout());

        // Delivery Personnel form
        JPanel formPanel = new JPanel(new GridLayout(5, 2));
        JTextField nameField = new JTextField();
        JTextField scheduleField = new JTextField();
        JTextField routesField = new JTextField();
        JTextField historyField = new JTextField();

        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Schedule:"));
        formPanel.add(scheduleField);
        formPanel.add(new JLabel("Assigned Routes:"));
        formPanel.add(routesField);
        formPanel.add(new JLabel("Delivery History:"));
        formPanel.add(historyField);

        JButton addPersonnelButton = new JButton("Add Personnel");
        JButton updatePersonnelButton = new JButton("Update Personnel");
        JButton deletePersonnelButton = new JButton("Delete Personnel");
        JButton viewPersonnelButton = new JButton("View Personnel");

        // Action listeners for personnel buttons
        addPersonnelButton.addActionListener(e -> {
            DeliveryPersonnel personnel = new DeliveryPersonnel(0, nameField.getText(), scheduleField.getText(), routesField.getText(), historyField.getText());
            personnelManager.addDeliveryPersonnel(personnel);
            JOptionPane.showMessageDialog(this, "Delivery Personnel added successfully!");
            clearPersonnelFields(nameField, scheduleField, routesField, historyField);
        });

        updatePersonnelButton.addActionListener(e -> {
            // Logic to update delivery personnel (you may want to add a way to select personnel to update)
            // For simplicity, this is left as a placeholder
            JOptionPane.showMessageDialog(this, "Update functionality not implemented yet.");
        });

        deletePersonnelButton.addActionListener(e -> {
            // Logic to delete delivery personnel (you may want to add a way to select personnel to delete)
            // For simplicity, this is left as a placeholder
            JOptionPane.showMessageDialog(this, "Delete functionality not implemented yet.");
        });

        viewPersonnelButton.addActionListener(e -> {
            List<DeliveryPersonnel> personnelList = personnelManager.getAllDeliveryPersonnel();
            StringBuilder personnelDetails = new StringBuilder("Delivery Personnel:\n");
            for (DeliveryPersonnel personnel : personnelList) {
                personnelDetails.append("ID: ").append(personnel.getId())
                        .append(", Name: ").append(personnel.getName())
                        .append(", Schedule: ").append(personnel.getSchedule())
                        .append(", Assigned Routes: ").append(personnel.getAssignedRoutes())
                        .append(", Delivery History: ").append(personnel.getDeliveryHistory()).append("\n");
            }
            JOptionPane.showMessageDialog(this, personnelDetails.toString());
        });

        personnelPanel.add(formPanel, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addPersonnelButton);
        buttonPanel.add(updatePersonnelButton);
        buttonPanel.add(deletePersonnelButton);
        buttonPanel.add(viewPersonnelButton);
        personnelPanel.add(buttonPanel, BorderLayout.SOUTH);

        return personnelPanel;
    }

    private void clearShipmentFields(JTextField senderField, JTextField receiverField, JTextField contentsField, JTextField statusField) {
        senderField.setText("");
        receiverField.setText("");
        contentsField.setText("");
        statusField.setText("Pending");
    }

    private void clearPersonnelFields(JTextField nameField, JTextField scheduleField, JTextField routesField, JTextField historyField) {
        nameField.setText("");
        scheduleField.setText("");
        routesField.setText("");
        historyField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}