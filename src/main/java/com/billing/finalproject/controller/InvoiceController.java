package com.billing.finalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.billing.finalproject.entity.Client;
import com.billing.finalproject.entity.Invoice;
import com.billing.finalproject.service.ClientService;
import com.billing.finalproject.service.InvoiceService;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("api/invoice")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private ClientService clientService;

    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Optional<Invoice>> getInvoiceById(@PathVariable Long id) {
        Optional<Invoice> invoice = invoiceService.findInvoiceById(id);
        if (invoice.isPresent()) {
            return ResponseEntity.ok(invoice);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Iterable<Invoice>> getInvoices() {
        return ResponseEntity.ok(invoiceService.findAll());
    }

    @PostMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
            MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Invoice> saveInvoice(@RequestBody Invoice invoice) {
        try {
            Long clientId = invoice.getClient().getId();
            Optional<Client> clientOptional = clientService.findClientById(clientId);

            if (clientOptional.isPresent()) {
                Client client = clientOptional.get();
                invoice.setClient(client);
                Invoice createdInvoice = invoiceService.save(invoice);
                return ResponseEntity.ok(createdInvoice);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
