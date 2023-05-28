package com.kenox.stock.salesservice.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor
@NoArgsConstructor
public class MedicamentDto {
    
    private Long id;
    private String name;
    private Date manufacturingDate;
    private Date expirationDate;
    private int quantity;
    private double unitPrice;
    
}
