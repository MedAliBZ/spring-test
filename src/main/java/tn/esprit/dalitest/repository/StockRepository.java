package tn.esprit.dalitest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.dalitest.entity.Client;
import tn.esprit.dalitest.entity.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
