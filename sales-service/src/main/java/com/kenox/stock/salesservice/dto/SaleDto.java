package com.kenox.stock.salesservice.dto;

import java.util.Date;

import com.kenox.stock.salesservice.entity.Sale;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor
@NoArgsConstructor
public class SaleDto {

    @NotNull
    private Long id;
    private Date saleDateTime;
    @NotNull
    private Long medicamentId;
    @NotNull
    private int quantity;
    @NotNull
    private double unitPrice;
    @NotNull
    private double totalPrice;

    public static Sale mapSale(SaleDto saleDto){
        Sale sale = new Sale();
        sale.setId(saleDto.getId());
        sale.setMedicamentId(saleDto.getMedicamentId());
        sale.setQuantity(saleDto.getQuantity());
        sale.setSaleDateTime(saleDto.getSaleDateTime());
        sale.setTotalPrice(saleDto.getTotalPrice());
        sale.setUnitPrice(saleDto.getUnitPrice());
        return sale;
    }
    
}
