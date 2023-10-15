package com.billing.finalproject.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.billing.finalproject.entity.Client;
import com.billing.finalproject.response.ResourceNotFoundException;
import com.billing.finalproject.service.ClientService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("api/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Operation(summary = "Get a client by id", description = "Get a client by id", tags = { "Client" })
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Client found", content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = Client.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Client not found", content = @io.swagger.v3.oas.annotations.media.Content)
    })
    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Optional<Client>> getClientById(@PathVariable Long id) {
        Optional<Client> client = clientService.findClientById(id);
        if (client.isPresent()) {
            return ResponseEntity.ok(client);
        } else {
            throw new ResourceNotFoundException("Client not found with ID: " + id);
        }
    }

    @Operation(summary = "Get all clients", description = "Get all clients", tags = { "Client" })
    @GetMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Iterable<Client>> getClients() {
        return ResponseEntity.ok(clientService.findAll());

    }

    @Operation(summary = "Save a client", description = "Save a client", tags = { "Client" })
    @PostMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
            MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Client> save(@RequestBody Client client) {
        try {
            Client clientSaved = clientService.save(client);
            return ResponseEntity.ok(clientSaved);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResourceNotFoundException("Client not saved");
        }
    }
}
