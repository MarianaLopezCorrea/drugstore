package com.kenox.drugstore.productservice.repository;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.kenox.drugstore.productservice.entity.Medicament;

public interface IMedicamentRepositoryPaging extends PagingAndSortingRepository<Medicament, Long > {

    List<Medicament> findAllByName(String name, Pageable pageable);


}