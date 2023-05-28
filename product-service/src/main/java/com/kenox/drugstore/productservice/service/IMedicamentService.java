package com.kenox.drugstore.productservice.service;


import com.kenox.drugstore.productservice.entity.Medicament;

public interface IMedicamentService {
    
    public Iterable<Medicament> findAllSort();
    public Iterable<Medicament> findAll();
    public Medicament findById(Long id);
    public Medicament createMedicament(Medicament medicament);
    public Medicament updateMedicament(Long id, Medicament medicament);
    public void deleteMedicament(Long id);

}
