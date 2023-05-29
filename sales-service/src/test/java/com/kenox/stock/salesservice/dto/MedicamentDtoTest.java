package com.kenox.stock.salesservice.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

public class MedicamentDtoTest {

    @Test
    public void testConstructorAndGetters() {
        Long id = 1L;
        String name = "Medicament A";
        Date manufacturingDate = new Date();
        Date expirationDate = new Date();
        int quantity = 10;
        double unitPrice = 5.0;

        MedicamentDto medicament = new MedicamentDto(id, name, manufacturingDate, expirationDate, quantity, unitPrice);

        assertThat(medicament.getId()).isEqualTo(id);
        assertThat(medicament.getName()).isEqualTo(name);
        assertThat(medicament.getManufacturingDate()).isEqualTo(manufacturingDate);
        assertThat(medicament.getExpirationDate()).isEqualTo(expirationDate);
        assertThat(medicament.getQuantity()).isEqualTo(quantity);
        assertThat(medicament.getUnitPrice()).isEqualTo(unitPrice);
    }

    @Test
    public void testSetters() {
        MedicamentDto medicament = new MedicamentDto();

        Long id = 1L;
        String name = "Medicament A";
        Date manufacturingDate = new Date();
        Date expirationDate = new Date();
        int quantity = 10;
        double unitPrice = 5.0;

        medicament.setId(id);
        medicament.setName(name);
        medicament.setManufacturingDate(manufacturingDate);
        medicament.setExpirationDate(expirationDate);
        medicament.setQuantity(quantity);
        medicament.setUnitPrice(unitPrice);

        assertThat(medicament.getId()).isEqualTo(id);
        assertThat(medicament.getName()).isEqualTo(name);
        assertThat(medicament.getManufacturingDate()).isEqualTo(manufacturingDate);
        assertThat(medicament.getExpirationDate()).isEqualTo(expirationDate);
        assertThat(medicament.getQuantity()).isEqualTo(quantity);
        assertThat(medicament.getUnitPrice()).isEqualTo(unitPrice);
    }
}
