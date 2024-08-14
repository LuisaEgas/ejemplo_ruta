package com.example.ruta.application.usecases;

import com.example.ruta.domain.models.Sale;
import com.example.ruta.domain.ports.out.SalesRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class AddSaleImplTest {

    @InjectMocks
    private AddSaleImpl addSaleImpl;

    @Mock
    private SalesRepositoryPort repositoryPort;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateSale() {
        Sale sale = new Sale(null, 100.0, null, "Test Sale");
        Sale savedSale = new Sale(1, 100.0, LocalDateTime.now(), "Test Sale");

        when(repositoryPort.saveSale(any(Sale.class))).thenReturn(savedSale);

        Sale result = addSaleImpl.createSale(sale);

        assertEquals(savedSale, result);
        verify(repositoryPort, times(1)).saveSale(any(Sale.class));
    }
}
