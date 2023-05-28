package com.kenox.drugstore.productservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.kenox.drugstore.productservice.entity.Medicament;

public interface IMedicamentRepository extends CrudRepository<Medicament, Long>{
    
}
