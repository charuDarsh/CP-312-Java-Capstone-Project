package com.perScholas.StockWatchListApplication.service.Interface;

import com.perScholas.StockWatchListApplication.model.Stock;

import java.util.List;
import java.util.Optional;

public interface StockService {
    Stock addStockToWatchlist(Long watchlistId, Stock stock);
    List<Stock> getStocksByWatchlist(Long watchlistId);
    void deleteStock(Long id);
    Optional<Stock> getStockById(Long id);
    void updateStock(Stock stock);
}
