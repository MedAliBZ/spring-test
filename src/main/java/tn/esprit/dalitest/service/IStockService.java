package tn.esprit.dalitest.service;

import tn.esprit.dalitest.entity.Stock;

import java.util.List;

public interface IStockService {
    List<Stock> retrieveAllStocks();
    Stock addStock(Stock s);
    Stock updateStock(Stock u);
    Stock retrieveStock(Long id);
}
