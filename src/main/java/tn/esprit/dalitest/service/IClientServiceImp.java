package tn.esprit.dalitest.service;

import org.springframework.stereotype.Service;
import tn.esprit.dalitest.entity.CategorieClient;
import tn.esprit.dalitest.entity.Client;
import tn.esprit.dalitest.entity.Facture;
import tn.esprit.dalitest.repository.ClientRepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public float getChiffreAffaireParCategorieClient(CategorieClient categorieClient, Date startDate, Date endDate) {
        List<Client> clients = clientRepository.getClientsByCategorieClient(categorieClient);
        float somme = 0;
        for(Client c : clients)
            somme += sommeFactureParDate(c,startDate, endDate);
        return somme;
    }

    private float sommeFactureParDate(Client client, Date dateD, Date dateF){
        float somme = (float) client.getFactures().stream()
                .filter(facture ->  facture.getActive() == false &&
                    facture.getDateFacture().after(dateD)  &&
                    facture.getDateFacture().before(dateF))
                .collect(Collectors.summarizingDouble(Facture::getMontantFacture))
                .getSum();
        return somme;
    }
}
