package com.example.ruta.infrastructure.controllers;

import com.example.ruta.application.services.SalesService;
import com.example.ruta.domain.models.Sale;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SaleController {

    private final SalesService salesService;

    public SaleController(SalesService salesService) {
        this.salesService = salesService;
    }

    @PostMapping("/create")
    public ResponseEntity<Sale> createSale(@RequestBody Sale sale) {
        try {
            Sale createdSale = salesService.createSale(sale);
            return new ResponseEntity<>(createdSale, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/report")
    public ResponseEntity<List<Sale>> reportSales() {
        try {
            List<Sale> sales = salesService.allSales();
            return new ResponseEntity<>(sales, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
