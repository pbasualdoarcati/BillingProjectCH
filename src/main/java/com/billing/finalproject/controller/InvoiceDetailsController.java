package com.billing.finalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.billing.finalproject.entity.InvoiceDetails;
import com.billing.finalproject.service.InvoiceDetailsService;
import java.util.Optional;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(value = "/api/invoice-details")
public class InvoiceDetailsController {
    @Autowired
    private InvoiceDetailsService invoiceDetailsService;

    @GetMapping(value = "/{id}", produces = { "application/json" })
    public ResponseEntity<Optional<InvoiceDetails>> getInvoiceDetailsById(@PathVariable Long id) {
        Optional<InvoiceDetails> invoiceDetails = invoiceDetailsService.findInvoiceDetailsById(id);
        if (invoiceDetails.isPresent()) {
            return ResponseEntity.ok(invoiceDetails);
        } else {
            return ResponseEntity.notFound().build();

        }
    }

    @GetMapping(value = "/", produces = { "application/json" })
    public ResponseEntity<Iterable<InvoiceDetails>> getInvoiceDetails() {
        return ResponseEntity.ok(invoiceDetailsService.findAll());
    }

    @PostMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
            MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<InvoiceDetails> saveInvoiceDetails(@RequestBody InvoiceDetails invoiceDetails) {
        try {
            InvoiceDetails createdInvoiceDetails = invoiceDetailsService.save(invoiceDetails);
            return ResponseEntity.ok(createdInvoiceDetails);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
