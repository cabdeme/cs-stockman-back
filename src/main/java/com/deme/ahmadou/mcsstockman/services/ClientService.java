package com.deme.ahmadou.mcsstockman.services;

import com.deme.ahmadou.mcsstockman.model.Client;
import com.deme.ahmadou.mcsstockman.repository.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getClients(){
        return this.clientRepository.findAll();
    }

    public Client getClientById(Long idClient){

        return this.clientRepository.findById(idClient).orElse(null);
    }

    public Client updateClient(Client client){
        log.info("Updating client: {}",client);

        Client clientToUpdate = this.clientRepository.findById(client.getId()).orElseThrow(() -> new IllegalStateException("Client not found"));

        return clientRepository.save(client);
    }

    public Client saveClient(Client client){
        log.info("Saving new client {}", client);
        return clientRepository.save(client);
    }

    public void deleteClient(Long clientId){
        log.info("Deleting client : {}",clientId);
        clientRepository.deleteById(clientId);

    }
}
