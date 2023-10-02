package com.billing.finalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.billing.finalproject.entity.Invoice;
import com.billing.finalproject.service.InvoiceService;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("api/invoice")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

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

    @PostMapping(value = "/", consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Invoice> saveInvoice(@RequestBody Invoice invoice) {
        try {
            Invoice createInvoice = invoiceService.save(invoice);
            return ResponseEntity.ok(createInvoice);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
