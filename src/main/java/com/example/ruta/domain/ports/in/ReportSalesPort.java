package com.example.ruta.domain.ports.in;

import com.example.ruta.domain.models.Sale;

import java.util.List;

public interface ReportSalesPort {
    List<Sale> generateReport();
}
