package tn.esprit.dalitest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.dalitest.entity.Rayon;

public interface RayonRepository extends JpaRepository<Rayon, Long> {
}
