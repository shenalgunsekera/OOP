package com.OOP.OOP;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "shipments")

public class shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "Sender")
    private String sender;

    @Column(name = "receiver")
    private String receiver;

    @Column(name = "contents")
    private String contents;

    @Column(name = "deliveryStatus")
    private String deliveryStatus;


    public shipment(int id, String sender, String receiver, String contents, String deliveryStatus) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.contents = contents;
        this.deliveryStatus = deliveryStatus;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
}
