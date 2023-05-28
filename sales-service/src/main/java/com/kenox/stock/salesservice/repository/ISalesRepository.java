package com.kenox.stock.salesservice.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kenox.stock.salesservice.entity.Sale;

public interface ISalesRepository extends JpaRepository<Sale, Long>{
    
    List<Sale> findAllSalesBySaleDateTimeBetween(Date saleStartDateTime, Date saleTimeEnd);

}
