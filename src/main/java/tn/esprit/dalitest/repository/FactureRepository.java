package tn.esprit.dalitest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.dalitest.entity.Client;
import tn.esprit.dalitest.entity.Facture;

import java.util.List;

public interface FactureRepository extends JpaRepository<Facture, Long> {
    List<Facture> getFactureByClientIdClient(long client_idClient);
}
