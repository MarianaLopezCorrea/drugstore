package com.kenox.drugstore.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kenox.drugstore.productservice.entity.Medicament;
import com.kenox.drugstore.productservice.service.IMedicamentService;

@RestController
@RequestMapping("/api/medicament")
@CrossOrigin(origins = "http://localhost:4200")
public class MedicamentController {

    @Autowired
    private IMedicamentService medicamentService;

    @GetMapping()
    public ResponseEntity<Iterable<Medicament>> getAll() {
        return ResponseEntity.ok(medicamentService.findAll());
    }

    @GetMapping("/pageable")
    public ResponseEntity<Iterable<Medicament>> getAllPaging() {
        return ResponseEntity.ok(medicamentService.findAllSort());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medicament> getById(@PathVariable("id") Long id) {
        Medicament medicament = medicamentService.findById(id);
        return medicament != null ? ResponseEntity.ok(medicament) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Medicament> createMedicament(@RequestBody Medicament medicament) {
        return ResponseEntity.ok(medicamentService.createMedicament(medicament));
    }

    @PutMapping("{id}")
    public ResponseEntity<Medicament> updateMedicament(@PathVariable("id") Long id, @RequestBody Medicament medicament) {
        Medicament medicamentDB = medicamentService.findById(id);
        if (medicamentDB == null) {
            return ResponseEntity.notFound().build();
        }
        medicament.setId(id);
        return ResponseEntity.ok(medicamentService.updateMedicament(id, medicament));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteMedicament(@PathVariable("id") Long id) {
        medicamentService.deleteMedicament(id);
        return ResponseEntity.ok().build();
    }

}