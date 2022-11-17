package tn.esprit.dalitest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.dalitest.entity.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
}
