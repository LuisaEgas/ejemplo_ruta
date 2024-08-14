package com.example.ruta.application.services;

import com.example.ruta.application.usecases.AddSaleImpl;
import com.example.ruta.application.usecases.ReportSalesImpl;
import com.example.ruta.domain.models.Sale;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class SalesServiceTest {

    @InjectMocks
    private SalesService salesService;

    @Mock
    private ReportSalesImpl reportSales;

    @Mock
    private AddSaleImpl addSale;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateSale() {
        Sale sale = new Sale(1, 100.0, null, "Test new sale");
        when(addSale.createSale(any(Sale.class))).thenReturn(sale);

        Sale createdSale = salesService.createSale(sale);

        assertEquals(sale, createdSale);
        verify(addSale, times(1)).createSale(sale);
    }

    @Test
    public void testAllSales() {
        List<Sale> sales = List.of(new Sale(1, 100.0, null, "Test Sale"));
        when(reportSales.generateReport()).thenReturn(sales);

        List<Sale> result = salesService.allSales();

        assertEquals(sales, result);
        verify(reportSales, times(1)).generateReport();
    }
}
