package com.billing.finalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
