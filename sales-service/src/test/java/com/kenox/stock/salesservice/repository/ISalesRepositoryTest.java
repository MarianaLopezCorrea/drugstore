package com.kenox.stock.salesservice.repository;

import com.kenox.stock.salesservice.entity.Sale;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@DataJpaTest
public class ISalesRepositoryTest {

    @Autowired
    private ISalesRepository salesRepository;

    @Test
    public void testFindAllSalesBySaleDateTimeBetween() {
        // Crear algunas ventas de prueba
        Sale sale1 = new Sale();
        sale1.setId(1L);
        sale1.setSaleDateTime(new Date(2023, 4, 1)); 
        salesRepository.save(sale1);

        Sale sale2 = new Sale();
        sale2.setId(2L);
        sale2.setSaleDateTime(new Date(2023, 5, 1)); 
        salesRepository.save(sale2);

        Sale sale3 = new Sale();
        sale3.setId(3L);
        sale3.setSaleDateTime(new Date(2023, 6, 1));
        salesRepository.save(sale3);

        Date saleStartDateTime = new Date(2023, 4, 1); 
        Date saleEndDateTime = new Date(2023, 5, 31); 
        List<Sale> sales = salesRepository.findAllSalesBySaleDateTimeBetween(saleStartDateTime, saleEndDateTime);

        assertNotEquals(sales, sale1);
    }
}
