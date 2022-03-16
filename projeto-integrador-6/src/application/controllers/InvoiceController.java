package application.controllers;

import application.models.entities.Invoice;
import application.repositories.InvoiceRepository;

import java.util.List;

public class InvoiceController {

    private final InvoiceRepository repository;

    public InvoiceController(InvoiceRepository repository) {
        this.repository = repository;
    }

    public Invoice create(Invoice invoice) {
        Invoice invoiceCreated = repository.create(invoice);
        return invoiceCreated;
    }

    public List<Invoice> findAll() {
        return repository.findAll();
    }

    public Invoice findByClientId(Integer clientId) {
        return repository.findByClientId(clientId);
    }

}
