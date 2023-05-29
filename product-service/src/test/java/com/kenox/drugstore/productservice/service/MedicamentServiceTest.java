package com.kenox.drugstore.productservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Sort;

import com.kenox.drugstore.productservice.MedicamentTestUtils;
import com.kenox.drugstore.productservice.entity.Medicament;
import com.kenox.drugstore.productservice.repository.IMedicamentRepository;
import com.kenox.drugstore.productservice.repository.IMedicamentRepositoryPaging;

public class MedicamentServiceTest {

    @Mock
    private IMedicamentRepository medicamentRepository;

    @Mock
    private IMedicamentRepositoryPaging medicamentRepositoryPaging;

    @InjectMocks
    private MedicamentService medicamentService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    public static final Iterable<Medicament> medicaments = MedicamentTestUtils.createListOfMedicaments();

    @Test
    public void testFindAllSort() {
        Sort sort = Sort.by("name").ascending();
        when(medicamentRepositoryPaging.findAll(sort)).thenReturn(medicaments);

        Iterable<Medicament> result = medicamentService.findAllSort();

        assertEquals(medicaments, result);
        verify(medicamentRepositoryPaging, times(1)).findAll(sort);
    }

    @Test
    public void testFindAll() {
        when(medicamentRepository.findAll()).thenReturn(medicaments);

        Iterable<Medicament> result = medicamentService.findAll();

        assertEquals(medicaments, result);
        verify(medicamentRepository, times(1)).findAll();
    }

    @Test
    public void testFindById_ExistingId() {
        Long id = 1L;
        Medicament medicament = new Medicament();
        when(medicamentRepository.findById(id)).thenReturn(Optional.of(medicament));

        Medicament result = medicamentService.findById(id);

        assertNotNull(result);
        assertEquals(medicament, result);
        verify(medicamentRepository, times(1)).findById(id);
    }

    @Test
    public void testFindById_NonExistingId() {
        Long id = 1L;
        when(medicamentRepository.findById(id)).thenReturn(Optional.empty());

        Medicament result = medicamentService.findById(id);

        assertNull(result);
        verify(medicamentRepository, times(1)).findById(id);
    }

    @Test
    public void testCreateMedicament() {
        
        Medicament medicament = new Medicament();
        when(medicamentRepository.save(medicament)).thenReturn(medicament);

        Medicament result = medicamentService.createMedicament(medicament);

        assertNotNull(result);
        assertEquals(medicament, result);
        verify(medicamentRepository, times(1)).save(medicament);
    }

    @Test
    public void testUpdateMedicament() {
        
        Long id = 1L;
        Medicament existingMedicament = new Medicament();
        existingMedicament.setId(id);
        Medicament updatedMedicament = new Medicament();
        updatedMedicament.setId(id);
        when(medicamentRepository.findById(id)).thenReturn(Optional.of(existingMedicament));
        when(medicamentRepository.save(updatedMedicament)).thenReturn(updatedMedicament);

        Medicament result = medicamentService.updateMedicament(id, updatedMedicament);

        assertNotNull(result);
        assertEquals(updatedMedicament, result);
        
        verify(medicamentRepository, times(1)).save(updatedMedicament);
    }

    @Test
    public void testDeleteMedicament() {
        
        Long id = 1L;

        medicamentService.deleteMedicament(id);

        verify(medicamentRepository, times(1)).deleteById(id);
    }
}
