package com.kenox.stock.salesservice.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kenox.stock.salesservice.entity.Sale;
import com.kenox.stock.salesservice.repository.ISalesRepository;

@Service
public class SaleService implements ISaleService {

    @Autowired
    private ISalesRepository salesRepository;

    @Override
    public Sale registerSales(Sale sale) {
        return salesRepository.save(sale);
    }

    @Override
    public Iterable<Sale> getAllSales() {
        return salesRepository.findAll();
    }

    @Override
    public Iterable<Sale> getAllSalesBySaleDateTimeBetween(Date saleStartDateTime, Date saleTimeEnd) {
        return salesRepository.findAllSalesBySaleDateTimeBetween(saleStartDateTime, saleTimeEnd);
    }

    

}
