package com.example.ruta.infrastructure.controller;

import com.example.ruta.application.services.SalesService;
import com.example.ruta.domain.models.Sale;
import com.example.ruta.infrastructure.controllers.SaleController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class SaleControllerTest {

    @InjectMocks
    private SaleController saleController;

    @Mock
    private SalesService salesService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateSale() {
        Sale sale = new Sale(null, 100.0, null, "Test Sale");
        Sale createdSale = new Sale(1, 100.0, null, "Test Sale");

        when(salesService.createSale(any(Sale.class))).thenReturn(createdSale);

        ResponseEntity<Sale> response = saleController.createSale(sale);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(createdSale, response.getBody());
    }

    @Test
    public void testReportSales() {
        List<Sale> sales = List.of(new Sale(1, 100.0, null, "Test Sale"));
        when(salesService.allSales()).thenReturn(sales);

        ResponseEntity<List<Sale>> response = saleController.reportSales();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(sales, response.getBody());
    }

    @Test
    public void testCreateSaleWithException() {
        Sale sale = new Sale(null, 100.0, null, "Test Sale");

        when(salesService.createSale(any(Sale.class))).thenThrow(new RuntimeException("Unexpected error"));

        ResponseEntity<Sale> response = saleController.createSale(sale);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    public void testReportSalesWithException() {
        when(salesService.allSales()).thenThrow(new RuntimeException("Unexpected error"));

        ResponseEntity<List<Sale>> response = saleController.reportSales();

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNull(response.getBody());
    }
}
