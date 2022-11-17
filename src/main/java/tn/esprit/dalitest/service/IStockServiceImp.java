package tn.esprit.dalitest.service;

import org.springframework.stereotype.Service;
import tn.esprit.dalitest.entity.Stock;
import tn.esprit.dalitest.repository.StockRepository;

import java.util.List;

@Service
public class IStockServiceImp implements IStockService {
    private StockRepository stockRepository;

    public IStockServiceImp(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public List<Stock> retrieveAllStocks() {
        return stockRepository.findAll();
    }

    @Override
    public Stock addStock(Stock s) {
        return stockRepository.save(s);
    }

    @Override
    public Stock updateStock(Stock u) {
        return stockRepository.save(u);
    }

    @Override
    public Stock retrieveStock(Long id) {
        return stockRepository.findById(id).orElse(null);
    }
}
