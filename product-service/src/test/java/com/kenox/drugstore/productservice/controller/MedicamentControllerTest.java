package com.kenox.drugstore.productservice.controller;

import com.kenox.drugstore.productservice.entity.Medicament;
import com.kenox.drugstore.productservice.service.IMedicamentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

class MedicamentControllerTest {

    @Mock
    private IMedicamentService medicamentService;

    @InjectMocks
    private MedicamentController medicamentController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        // Arrange
        List<Medicament> medicamentList = new ArrayList<>();
        when(medicamentService.findAll()).thenReturn(medicamentList);

        // Act
        ResponseEntity<Iterable<Medicament>> response = medicamentController.getAll();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(medicamentList, response.getBody());
    }

    @Test
    void testGetById_existingId() {
        // Arrange
        Long id = 1L;
        Medicament medicament = new Medicament();
        when(medicamentService.findById(id)).thenReturn(medicament);

        // Act
        ResponseEntity<Medicament> response = medicamentController.getById(id);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(medicament, response.getBody());
    }

    @Test
    void testGetById_nonExistingId() {
        // Arrange
        Long id = 1L;
        when(medicamentService.findById(id)).thenReturn(null);

        // Act
        ResponseEntity<Medicament> response = medicamentController.getById(id);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    void testCreateMedicament() {
        // Arrange
        Medicament medicament = new Medicament();
        when(medicamentService.createMedicament(medicament)).thenReturn(medicament);

        // Act
        ResponseEntity<Medicament> response = medicamentController.createMedicament(medicament);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(medicament, response.getBody());
    }

    @Test
    void testUpdateMedicament_existingId() {
        // Arrange
        Long id = 1L;
        Medicament medicament = new Medicament();
        when(medicamentService.findById(id)).thenReturn(medicament);
        when(medicamentService.updateMedicament(id, medicament)).thenReturn(medicament);

        // Act
        ResponseEntity<Medicament> response = medicamentController.updateMedicament(id, medicament);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(medicament, response.getBody());
    }

    @Test
    void testUpdateMedicament_nonExistingId() {
        // Arrange
        Long id = 1L;
        Medicament medicament = new Medicament();
        when(medicamentService.findById(id)).thenReturn(null);

        // Act
        ResponseEntity<Medicament> response = medicamentController.updateMedicament(id, medicament);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    void testDeleteMedicament() {
        // Arrange
        Long id = 1L;

        // Act
        ResponseEntity<HttpStatus> response = medicamentController.deleteMedicament(id);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(medicamentService, times(1)).deleteMedicament(id);
    }
}
