package tn.esprit.dalitest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.dalitest.entity.CategorieClient;
import tn.esprit.dalitest.entity.Client;
import tn.esprit.dalitest.entity.Facture;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> getClientsByCategorieClient(CategorieClient categorieClient);
}
