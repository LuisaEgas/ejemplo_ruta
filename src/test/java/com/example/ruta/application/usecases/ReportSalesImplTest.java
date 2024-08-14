package com.example.ruta.application.usecases;

import com.example.ruta.domain.models.Sale;
import com.example.ruta.domain.ports.out.SalesRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ReportSalesImplTest {

    @InjectMocks
    private ReportSalesImpl reportSalesImpl;

    @Mock
    private SalesRepositoryPort repositoryPort;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGenerateReport() {
        List<Sale> sales = List.of(new Sale(1, 100.0, null, "Test Sale"));
        when(repositoryPort.getSales()).thenReturn(sales);

        List<Sale> result = reportSalesImpl.generateReport();

        assertEquals(sales, result);
        verify(repositoryPort, times(1)).getSales();
    }
}
