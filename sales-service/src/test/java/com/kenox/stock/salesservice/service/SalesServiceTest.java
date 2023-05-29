package com.kenox.stock.salesservice.service;

import com.kenox.stock.salesservice.entity.Sale;
import com.kenox.stock.salesservice.repository.ISalesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class SalesServiceTest {

    @Mock
    private ISalesRepository salesRepository;

    @InjectMocks
    private SaleService saleService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRegisterSales() {
        Sale sale = new Sale();

        when(salesRepository.save(sale)).thenReturn(sale);
        Sale result = saleService.registerSales(sale);

        assertEquals(sale, result);
        verify(salesRepository, times(1)).save(sale);
    }

    @Test
    public void testGetAllSales() {
        List<Sale> salesList = new ArrayList<>();
        salesList.add(new Sale());
        salesList.add(new Sale());

        when(salesRepository.findAll()).thenReturn(salesList);
        Iterable<Sale> result = saleService.getAllSales();

        assertEquals(salesList, result);
        verify(salesRepository, times(1)).findAll();
    }

    @Test
    public void testGetAllSalesBySaleDateTimeBetween() {
        Date saleStartDateTime = new Date();
        Date saleTimeEnd = new Date();
        List<Sale> salesList = new ArrayList<>();
        salesList.add(new Sale());
        salesList.add(new Sale());

        when(salesRepository.findAllSalesBySaleDateTimeBetween(saleStartDateTime, saleTimeEnd)).thenReturn(salesList);
        Iterable<Sale> result = saleService.getAllSalesBySaleDateTimeBetween(saleStartDateTime, saleTimeEnd);

        assertEquals(salesList, result);
        verify(salesRepository, times(1)).findAllSalesBySaleDateTimeBetween(saleStartDateTime, saleTimeEnd);
    }
}
