package com.kenox.drugstore.productservice.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

public class MedicamentDtoTest {

    @Test
    public void testGetterAndSetter() {
        Long id = 1L;
        String name = "Medicament";
        Date manufacturingDate = new Date();
        Date expirationDate = new Date();
        int quantity = 10;
        double unitPrice = 9.99;

        MedicamentDto medicamentDto = new MedicamentDto();
        medicamentDto.setId(id);
        medicamentDto.setName(name);
        medicamentDto.setManufacturingDate(manufacturingDate);
        medicamentDto.setExpirationDate(expirationDate);
        medicamentDto.setQuantity(quantity);
        medicamentDto.setUnitPrice(unitPrice);

        assertEquals(id, medicamentDto.getId());
        assertEquals(name, medicamentDto.getName());
        assertEquals(manufacturingDate, medicamentDto.getManufacturingDate());
        assertEquals(expirationDate, medicamentDto.getExpirationDate());
        assertEquals(quantity, medicamentDto.getQuantity());
        assertEquals(unitPrice, medicamentDto.getUnitPrice(), 0.001);
    }

    @Test
    public void testAllArgsConstructor() {
        Long id = 1L;
        String name = "Medicament";
        Date manufacturingDate = new Date();
        Date expirationDate = new Date();
        int quantity = 10;
        double unitPrice = 9.99;

        MedicamentDto medicamentDto = new MedicamentDto(id, name, manufacturingDate, expirationDate, quantity, unitPrice);

        assertEquals(id, medicamentDto.getId());
        assertEquals(name, medicamentDto.getName());
        assertEquals(manufacturingDate, medicamentDto.getManufacturingDate());
        assertEquals(expirationDate, medicamentDto.getExpirationDate());
        assertEquals(quantity, medicamentDto.getQuantity());
        assertEquals(unitPrice, medicamentDto.getUnitPrice(), 0.001);
    }

    @Test
    public void testNoArgsConstructor() {
        MedicamentDto medicamentDto = new MedicamentDto();
        assertNull(medicamentDto.getId());
        assertNull(medicamentDto.getName());
        assertNull(medicamentDto.getManufacturingDate());
        assertNull(medicamentDto.getExpirationDate());
        assertEquals(0, medicamentDto.getQuantity());
        assertEquals(0.0, medicamentDto.getUnitPrice(), 0.001);
    }
}
