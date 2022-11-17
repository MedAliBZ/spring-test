package tn.esprit.dalitest.service;

import org.springframework.stereotype.Service;
import tn.esprit.dalitest.entity.Fournisseur;
import tn.esprit.dalitest.entity.Produit;
import tn.esprit.dalitest.entity.Rayon;
import tn.esprit.dalitest.entity.Stock;
import tn.esprit.dalitest.repository.FournisseurRepository;
import tn.esprit.dalitest.repository.ProduitRepository;
import tn.esprit.dalitest.repository.RayonRepository;
import tn.esprit.dalitest.repository.StockRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class IProduitServiceImp implements IProduitService{
    private final ProduitRepository produitRepository;
    private final StockRepository stockRepository;
    private final RayonRepository rayonRepository;
    private final FournisseurRepository fournisseurRepository;

    public IProduitServiceImp(ProduitRepository produitRepository, StockRepository stockRepository, RayonRepository rayonRepository, FournisseurRepository fournisseurRepository) {
        this.produitRepository = produitRepository;
        this.stockRepository = stockRepository;
        this.rayonRepository = rayonRepository;
        this.fournisseurRepository = fournisseurRepository;
    }

    @Override
    public List<Produit> retrieveAllProduits() {
        return produitRepository.findAll();
    }

    @Transactional
    @Override
    public Produit addProduit(Produit p, Long idRayon, Long idStock) {
        Rayon rayon = rayonRepository.findById(idRayon).orElse(null);
        Stock stock = stockRepository.findById(idStock).orElse(null);
        p.setRayon(rayon);
        p.setStock(stock);
        return produitRepository.save(p);
    }

    @Override
    public Produit retrieveProduit(Long id) {
        return produitRepository.findById(id).orElse(null);
    }

    @Override
    public void assignProduitToStock(Long idProduit, Long idStock) {
        Produit produit = this.retrieveProduit(idProduit);
        Stock stock = this.stockRepository.findById(idStock).orElse(null);
        if(produit != null && stock != null) {
            produit.setStock(stock);
        }
    }

    @Override
    public void assignFournisseurToProduit(Long fournisseurId, Long produitId) {
        Produit produit = this.retrieveProduit(produitId);
        Fournisseur fournisseur = this.fournisseurRepository.findById(fournisseurId).orElse(null);
        if(produit != null && fournisseur != null) {
            produit.getFournisseurs().add(fournisseur);
            produitRepository.save(produit);
        }
    }
}
