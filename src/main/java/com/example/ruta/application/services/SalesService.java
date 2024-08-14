package com.example.ruta.application.services;

import com.example.ruta.application.usecases.AddSaleImpl;
import com.example.ruta.application.usecases.ReportSalesImpl;
import com.example.ruta.domain.models.Sale;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesService {

    private final ReportSalesImpl reportSales;
    private final AddSaleImpl addSale;

    public SalesService(ReportSalesImpl reportSales, AddSaleImpl addSale) {
        this.reportSales = reportSales;
        this.addSale = addSale;
    }

    public Sale createSale(final Sale sale) {
        return addSale.createSale(sale);
    }

    public List<Sale> allSales() {
        return reportSales.generateReport();
    }
}
