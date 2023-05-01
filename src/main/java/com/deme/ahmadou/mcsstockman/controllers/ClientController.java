package com.deme.ahmadou.mcsstockman.controllers;

import com.deme.ahmadou.mcsstockman.model.Client;
import com.deme.ahmadou.mcsstockman.services.ClientService;
import com.deme.ahmadou.mcsstockman.services.DepotService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/clients")
@CrossOrigin(origins = "*")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> getClients(){
        return this.clientService.getClients();
    }

    @GetMapping("/{id}")
    public Client getClient(@PathVariable Long id){
        return this.clientService.getClientById(id);
    }

    @PutMapping("/{id}")
    public Client updateClient(@PathVariable(name = "id") Long customerId,@RequestBody Client client){
        client.setId(customerId);
        return clientService.updateClient(client);
    }

    @PostMapping
    public Client saveClient(@RequestBody Client client){
        return clientService.saveClient(client);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id){
        this.clientService.deleteClient(id);
    }
}
