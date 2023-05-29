package com.kenox.drugstore.productservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kenox.drugstore.productservice.entity.Medicament;

public class MedicamentTestUtils {

    public static List<Medicament> createListOfMedicaments() {
        List<Medicament> medicaments = new ArrayList<>();

        // Crear medicamentos de ejemplo
        Medicament medicament1 = new Medicament();
        medicament1.setId(1L);
        medicament1.setName("Medicament 1");
        medicament1.setManufacturingDate(new Date());
        medicament1.setExpirationDate(new Date());
        medicament1.setQuantity(10);
        medicament1.setUnitPrice(9.99);

        Medicament medicament2 = new Medicament();
        medicament2.setId(2L);
        medicament2.setName("Medicament 2");
        medicament2.setManufacturingDate(new Date());
        medicament2.setExpirationDate(new Date());
        medicament2.setQuantity(20);
        medicament2.setUnitPrice(19.99);

        // Agregar medicamentos a la lista
        medicaments.add(medicament1);
        medicaments.add(medicament2);

        return medicaments;
    }

}
