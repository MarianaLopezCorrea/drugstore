
package com.kenox.drugstore.productservice.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data 
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "medicaments")
public class Medicament implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    @NotNull
    private String name;

    @NotNull
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date manufacturingDate;

    @NotNull
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date expirationDate;

    @NotNull
    private int quantity;

    @NotNull
    private double unitPrice;

}