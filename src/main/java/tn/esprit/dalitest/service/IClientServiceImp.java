package tn.esprit.dalitest.service;

import org.springframework.stereotype.Service;
import tn.esprit.dalitest.entity.Client;
import tn.esprit.dalitest.repository.ClientRepository;

import java.util.List;

@Service
public class IClientServiceImp implements IClientService {
    private final ClientRepository clientRepository;

    public IClientServiceImp(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @Override
    public List<Client> retrieveAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client addClient(Client c) {
        return clientRepository.save(c);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Client updateClient(Client c) {
        return clientRepository.save(c);
    }

    @Override
    public Client retrieveClient(Long id) {
        return clientRepository.findById(id).orElse(null);
    }
}
