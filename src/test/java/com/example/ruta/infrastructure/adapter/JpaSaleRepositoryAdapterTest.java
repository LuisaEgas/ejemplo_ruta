package com.example.ruta.infrastructure.adapter;

import com.example.ruta.domain.models.Sale;
import com.example.ruta.infrastructure.adapters.JpaSaleRepositoryAdapter;
import com.example.ruta.infrastructure.entities.SaleEntity;
import com.example.ruta.infrastructure.repositories.JpaSaleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class JpaSaleRepositoryAdapterTest {

    @InjectMocks
    private JpaSaleRepositoryAdapter jpaSaleRepositoryAdapter;

    @Mock
    private JpaSaleRepository jpaSaleRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveSale() {
        Sale sale = new Sale(null, 100.0, LocalDateTime.now(), "Test Sale");
        SaleEntity saleEntity = new SaleEntity(null, 100.0, LocalDateTime.now(), "Test Sale");
        SaleEntity savedSaleEntity = new SaleEntity(1, 100.0, LocalDateTime.now(), "Test Sale");

        when(jpaSaleRepository.save(any(SaleEntity.class))).thenReturn(savedSaleEntity);

        Sale result = jpaSaleRepositoryAdapter.saveSale(sale);

        assertEquals(1, result.getId());
        verify(jpaSaleRepository, times(1)).save(any(SaleEntity.class));
    }

    @Test
    public void testGetSales() {
        SaleEntity saleEntity = new SaleEntity(1, 100.0, LocalDateTime.now(), "Test Sale");
        List<SaleEntity> saleEntities = List.of(saleEntity);

        when(jpaSaleRepository.findAll()).thenReturn(saleEntities);

        List<Sale> result = jpaSaleRepositoryAdapter.getSales();

        assertEquals(1, result.size());
        verify(jpaSaleRepository, times(1)).findAll();
    }
}
