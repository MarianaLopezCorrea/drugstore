package com.kenox.stock.salesservice.dto;
import org.junit.jupiter.api.Test;

import com.kenox.stock.salesservice.entity.Sale;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

public class SaleDtoTest {

    @Test
    public void testConstructorAndGetters() {
        Long id = 1L;
        Date saleDateTime = new Date();
        Long medicamentId = 2L;
        int quantity = 5;
        double unitPrice = 10.0;
        double totalPrice = 50.0;

        SaleDto saleDto = new SaleDto(id, saleDateTime, medicamentId, quantity, unitPrice, totalPrice);

        assertThat(saleDto.getId()).isEqualTo(id);
        assertThat(saleDto.getSaleDateTime()).isEqualTo(saleDateTime);
        assertThat(saleDto.getMedicamentId()).isEqualTo(medicamentId);
        assertThat(saleDto.getQuantity()).isEqualTo(quantity);
        assertThat(saleDto.getUnitPrice()).isEqualTo(unitPrice);
        assertThat(saleDto.getTotalPrice()).isEqualTo(totalPrice);
    }

    @Test
    public void testSetters() {
        SaleDto saleDto = new SaleDto();

        Long id = 1L;
        Date saleDateTime = new Date();
        Long medicamentId = 2L;
        int quantity = 5;
        double unitPrice = 10.0;
        double totalPrice = 50.0;

        saleDto.setId(id);
        saleDto.setSaleDateTime(saleDateTime);
        saleDto.setMedicamentId(medicamentId);
        saleDto.setQuantity(quantity);
        saleDto.setUnitPrice(unitPrice);
        saleDto.setTotalPrice(totalPrice);

        assertThat(saleDto.getId()).isEqualTo(id);
        assertThat(saleDto.getSaleDateTime()).isEqualTo(saleDateTime);
        assertThat(saleDto.getMedicamentId()).isEqualTo(medicamentId);
        assertThat(saleDto.getQuantity()).isEqualTo(quantity);
        assertThat(saleDto.getUnitPrice()).isEqualTo(unitPrice);
        assertThat(saleDto.getTotalPrice()).isEqualTo(totalPrice);
    }

    @Test
    public void testMapSale() {
        SaleDto saleDto = new SaleDto(1L, new Date(), 2L, 5, 10.0, 50.0);

        Sale sale = SaleDto.mapSale(saleDto);

        assertThat(sale.getId()).isEqualTo(saleDto.getId());
        assertThat(sale.getSaleDateTime()).isEqualTo(saleDto.getSaleDateTime());
        assertThat(sale.getMedicamentId()).isEqualTo(saleDto.getMedicamentId());
        assertThat(sale.getQuantity()).isEqualTo(saleDto.getQuantity());
        assertThat(sale.getUnitPrice()).isEqualTo(saleDto.getUnitPrice());
        assertThat(sale.getTotalPrice()).isEqualTo(saleDto.getTotalPrice());
    }
}
