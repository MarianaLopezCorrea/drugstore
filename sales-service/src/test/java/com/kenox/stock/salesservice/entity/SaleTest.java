package com.kenox.stock.salesservice.entity;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class SaleTest {

    @Test
    public void testConstructorAndGetters() {
        Long id = 1L;
        Date saleDateTime = new Date();
        Long medicamentId = 2L;
        int quantity = 5;
        double unitPrice = 10.0;
        double totalPrice = 50.0;

        Sale sale = new Sale(id, saleDateTime, medicamentId, quantity, unitPrice, totalPrice);

        assertThat(sale.getId()).isEqualTo(id);
        assertThat(sale.getSaleDateTime()).isEqualTo(saleDateTime);
        assertThat(sale.getMedicamentId()).isEqualTo(medicamentId);
        assertThat(sale.getQuantity()).isEqualTo(quantity);
        assertThat(sale.getUnitPrice()).isEqualTo(unitPrice);
        assertThat(sale.getTotalPrice()).isEqualTo(totalPrice);
    }

    @Test
    public void testSetters() {
        Sale sale = new Sale();

        Long id = 1L;
        Date saleDateTime = new Date();
        Long medicamentId = 2L;
        int quantity = 5;
        double unitPrice = 10.0;
        double totalPrice = 50.0;

        sale.setId(id);
        sale.setSaleDateTime(saleDateTime);
        sale.setMedicamentId(medicamentId);
        sale.setQuantity(quantity);
        sale.setUnitPrice(unitPrice);
        sale.setTotalPrice(totalPrice);

        assertThat(sale.getId()).isEqualTo(id);
        assertThat(sale.getSaleDateTime()).isEqualTo(saleDateTime);
        assertThat(sale.getMedicamentId()).isEqualTo(medicamentId);
        assertThat(sale.getQuantity()).isEqualTo(quantity);
        assertThat(sale.getUnitPrice()).isEqualTo(unitPrice);
        assertThat(sale.getTotalPrice()).isEqualTo(totalPrice);
    }

    @Test
    public void testPrePersist() {
        Sale sale = new Sale();
        sale.onCreate();

        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Bogota"));
        Date expectedSaleDateTime = calendar.getTime();

        assertThat(sale.getSaleDateTime()).isEqualTo(expectedSaleDateTime);
    }
}
