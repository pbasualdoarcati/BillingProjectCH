package com.billing.finalproject.service;

import com.billing.finalproject.entity.Client;
import com.billing.finalproject.entity.Invoice;
import com.billing.finalproject.entity.InvoiceDetails;
import com.billing.finalproject.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;
    @Autowired
    private ClientService clientService;
    @Autowired
    private ProductService productService;

    public Invoice save(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    public void delete(Long id) {
        invoiceRepository.deleteById(id);
    }

    public Optional<Invoice> findInvoiceById(Long id) {
        return invoiceRepository.findById(id);
    }

    public Iterable<Invoice> findAll() {
        return invoiceRepository.findAll();
    }

    public Invoice saveWithDetails(Invoice invoice) {
        Long clientId = invoice.getClient().getClientId();
        Optional<Client> clientOptional = clientService.findClientById(clientId);
        invoice.setCreatedAt(new Date());
        if (clientOptional.isEmpty())
            throw new RuntimeException("The client not exists");

        Client client = clientOptional.get();
        invoice.setClient(client);

        var details = invoice.getInvoiceDetails();
        var aux = 0d;
        if (details != null)
            for (InvoiceDetails id : details) {
                Long productId = id.getProduct().getProductId();
                Long amount = id.getAmount();

                var newStockWithSell = productService.updateStockWithSell(productId, amount);
                if (newStockWithSell < 0)
                    throw new RuntimeException("There is not enough stock for the product with ID " + productId);

                id.getProduct().setStock(newStockWithSell);

                id.setPrice(productService.getProductPrice(id.getProduct().getProductId()) * id.getAmount());
                aux += id.getPrice();

            }
        invoice.setTotal(aux);

        return save(invoice);
    }
}
