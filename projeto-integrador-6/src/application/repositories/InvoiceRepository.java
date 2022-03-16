package application.repositories;

import application.models.entities.Invoice;
import application.repositories.intefaces.IInvoiceRepository;

import java.util.ArrayList;
import java.util.List;

public class InvoiceRepository implements IInvoiceRepository {

    private final static List<Invoice> invoices = new ArrayList<>();

    @Override
    public Invoice create(Invoice obj) {
        invoices.add(obj);
        return obj;
    }

    @Override
    public Invoice findById(Integer id) {
        return invoices.stream().filter(i -> i.getID().equals(id)).findFirst().orElse(null);

    }

    @Override
    public void deleteById(Integer id) {
        invoices.remove(invoices.stream().filter(i -> i.getID().equals(id)).findFirst().orElse(null));
    }

    @Override
    public List<Invoice> findAll() {
        return invoices;
    }


    @Override
    public Invoice findByClientId(Integer clientId) {
            return invoices.stream().filter(i -> i.getClient().getID().equals(clientId)).findFirst().orElse(null);
    }
}
