package tn.esprit.dalitest.controller;

import org.springframework.web.bind.annotation.*;
import tn.esprit.dalitest.entity.Client;
import tn.esprit.dalitest.service.IClientService;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    final private IClientService clientService;

    public ClientController(IClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    List<Client> findall() {
        return this.clientService.retrieveAllClients();
    }

    @PostMapping
    Client addClient(@RequestBody Client c) {
        return this.clientService.addClient(c);
    }

    @DeleteMapping("/{id}")
    void deleteClient(@PathVariable Long id){
        this.clientService.deleteClient(id);
    }

    @PatchMapping
    Client updateClient(@RequestBody Client c){
        return this.clientService.updateClient(c);
    }

    @GetMapping("/{id}")
    Client retrieveClient(@PathVariable Long id){
        return this.clientService.retrieveClient(id);
    }

}
