package com.kenox.drugstore.productservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.kenox.drugstore.productservice.entity.Medicament;
import com.kenox.drugstore.productservice.repository.IMedicamentRepository;
import com.kenox.drugstore.productservice.repository.IMedicamentRepositoryPaging;

@Service
public class MedicamentService implements IMedicamentService {

    @Autowired
    private IMedicamentRepository medicamentRepository;

    @Autowired
    private IMedicamentRepositoryPaging medicamentRepositoryPaging;

    @Override
    public Iterable<Medicament> findAllSort() {
        return medicamentRepositoryPaging.findAll(Sort.by("name").ascending());
    }

    @Override
    public Iterable<Medicament> findAll() {
        return medicamentRepository.findAll();
    }

    @Override
    public Medicament findById(Long id){
        return medicamentRepository.findById(id).orElse(null);
    }

    @Override
    public Medicament createMedicament(Medicament medicament) {
        return medicamentRepository.save(medicament);
    }

    @Override
    public Medicament updateMedicament(Long id, Medicament medicament) {
        return medicamentRepository.save(medicament);
    }

    @Override
    public void deleteMedicament(Long id) {
        medicamentRepository.deleteById(id);
    }

}
