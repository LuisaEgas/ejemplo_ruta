package com.example.ruta.application.usecases;

import com.example.ruta.domain.models.Sale;
import com.example.ruta.domain.ports.in.ReportSalesPort;
import com.example.ruta.domain.ports.out.SalesRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportSalesImpl implements ReportSalesPort {

    private final SalesRepositoryPort repositoryPort;

    public ReportSalesImpl(SalesRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public List<Sale> generateReport() {
        return repositoryPort.getSales();
    }


}
