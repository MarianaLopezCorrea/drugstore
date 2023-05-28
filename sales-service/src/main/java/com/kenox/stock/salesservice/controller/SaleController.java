package com.kenox.stock.salesservice.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.kenox.stock.salesservice.dto.MedicamentDto;
import com.kenox.stock.salesservice.dto.SaleDto;
import com.kenox.stock.salesservice.entity.Sale;
import com.kenox.stock.salesservice.service.ISaleService;

@RestController
@RequestMapping("/api/sale")
@CrossOrigin(origins = "http://localhost:4200")
public class SaleController {

    @Autowired
    private ISaleService saleService;

    @Autowired
    private final RestTemplate restTemplate = new RestTemplate();

    @PostMapping
    public ResponseEntity<Sale> registerSale(@RequestBody SaleDto sale) {
        Sale saleEntity = SaleDto.mapSale(sale);
        return ResponseEntity.ok(saleService.registerSales(saleEntity));
    }

    @GetMapping
    public ResponseEntity<Iterable<Sale>> getAllSales() {
        return ResponseEntity.ok(saleService.getAllSales());
    }

    @GetMapping("/filter_by_date")
    public ResponseEntity<Iterable<Sale>> getAllSalesByTimeBetween(
            @RequestParam(value = "startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date startDate,
            @RequestParam(value = "endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date endDateTime) {
        return ResponseEntity.ok(saleService.getAllSalesBySaleDateTimeBetween(startDate, endDateTime));
    }

    @GetMapping("/get_unit_price/{id}")
    public ResponseEntity<Double> getMedicamentById(@PathVariable(value = "id") Long id, @RequestParam(value = "quantity") Integer quantity) {
        Double totalPrice = 0.0;
        String url = "http://localhost:8090/api/medicament/" + id;
        MedicamentDto medicament = null;
        try{
            medicament = restTemplate.getForObject(url, MedicamentDto.class);
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }

        if(medicament != null){
            Double unitPrice = medicament.getUnitPrice();
            totalPrice = unitPrice * quantity;
        }
        return ResponseEntity.ok(totalPrice);
    }

    @PutMapping("/confirm_sale/{id}")
    public ResponseEntity<MedicamentDto> confirmSale(@PathVariable("id") Long id, @RequestParam(value = "quantity") Integer quantity) {
        String url = "http://localhost:8090/api/medicament/" + id;
        MedicamentDto medicament = null;
        //Obtener medicamento y calcular el inventario nuevo
        try {
            medicament = restTemplate.getForObject(url, MedicamentDto.class);
            if(medicament == null){
                return ResponseEntity.badRequest().build();
            }else{
                int newQuantity = medicament.getQuantity() - quantity;
                medicament.setQuantity(newQuantity);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        //Actualizar medicamento con el nuevo inventario
        try {
            restTemplate.put(url, medicament);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        //Registrar venta
        try{
            SaleDto sale = new SaleDto();
            sale.setMedicamentId(id);
            sale.setQuantity(quantity);
            sale.setUnitPrice(medicament.getUnitPrice());
            sale.setTotalPrice(medicament.getUnitPrice() * quantity);
            Sale saleEntity = SaleDto.mapSale(sale);
            saleService.registerSales(saleEntity);
            return ResponseEntity.ok(medicament);
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    
}
