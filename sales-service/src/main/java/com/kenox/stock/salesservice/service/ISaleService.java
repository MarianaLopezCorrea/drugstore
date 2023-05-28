package com.kenox.stock.salesservice.service;

import java.util.Date;

import com.kenox.stock.salesservice.entity.Sale;

public interface ISaleService {

    public Sale registerSales(Sale sale);
    public Iterable<Sale> getAllSales();
    public Iterable<Sale> getAllSalesBySaleDateTimeBetween(Date saleStartDateTime, Date saleTimeEnd);
}
