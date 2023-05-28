package com.kenox.stock.salesservice.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data 
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sales")
public class Sale implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date saleDateTime;
    private Long medicamentId;
    private int quantity;
    private double unitPrice;
    private double totalPrice;

    @PrePersist
    protected void onCreate() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Bogota"));
        saleDateTime = calendar.getTime();
    }

}
