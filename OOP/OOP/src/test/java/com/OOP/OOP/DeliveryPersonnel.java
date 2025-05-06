package com.OOP.OOP;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "delivery_personnel")

public class DeliveryPersonnel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "schedule")
    private String schedule;

    @Column(name = "assignedRoutes")
    private String assignedRoutes;

    @Column(name = "deliveryHistory")
    private String deliveryHistory;

    public DeliveryPersonnel(int id, String name, String schedule, String assignedRoutes, String deliveryHistory) {
        this.id = id;
        this.name = name;
        this.schedule = schedule;
        this.assignedRoutes = assignedRoutes;
        this.deliveryHistory = deliveryHistory;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getAssignedRoutes() {
        return assignedRoutes;
    }

    public void setAssignedRoutes(String assignedRoutes) {
        this.assignedRoutes = assignedRoutes;
    }

    public String getDeliveryHistory() {
        return deliveryHistory;
    }

    public void setDeliveryHistory(String deliveryHistory) {
        this.deliveryHistory = deliveryHistory;
    }
}