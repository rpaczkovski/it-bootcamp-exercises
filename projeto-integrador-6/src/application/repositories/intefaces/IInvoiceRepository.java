package application.repositories.intefaces;

import application.models.entities.Invoice;

public interface IInvoiceRepository extends IRepository<Integer, Invoice> {
    Invoice findByClientId(Integer clientId);
}
