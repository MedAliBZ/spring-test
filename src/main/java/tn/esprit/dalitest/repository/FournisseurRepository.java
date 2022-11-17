package tn.esprit.dalitest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.dalitest.entity.Fournisseur;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {
}
