package com.billing.finalproject.controller;

import com.billing.finalproject.entity.Invoice;
import com.billing.finalproject.response.ResourceNotFoundException;
import com.billing.finalproject.service.InvoiceService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/invoice")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @Operation(summary = "Get invoice by id", description = "Get invoice by id", tags = { "Invoice" })
    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Invoice retrieved successfully"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "404", description = "Invoice not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<Optional<Invoice>> getInvoiceById(@PathVariable Long id) {
        Optional<Invoice> invoice = invoiceService.findInvoiceById(id);
        if (invoice.isPresent()) {
            return ResponseEntity.ok(invoice);
        } else {
            throw new ResourceNotFoundException("Invoice not found");
        }
    }

    @Operation(summary = "Get all invoices", description = "Get all invoices", tags = { "Invoice" })
    @GetMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Invoices retrieved successfully"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<Iterable<Invoice>> getInvoices() {
        return ResponseEntity.ok(invoiceService.findAll());
    }

    @PostMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
            MediaType.APPLICATION_JSON_VALUE })
    @Operation(summary = "Create Invoice with Details", description = "Creates an invoice with client and details.", tags = {
            "Invoice" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Invoice created successfully"),
            @ApiResponse(responseCode = "400", description = "Bad Request")
    })
    public ResponseEntity<Invoice> saveInvoiceWithDetails(@RequestBody Invoice invoice) {
        try {
            var response = invoiceService.saveWithDetails(invoice);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResourceNotFoundException("Invoice not created");
        }
    }

}
