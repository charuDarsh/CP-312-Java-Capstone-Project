package com.perScholas.StockWatchListApplication.service.Impl;

import com.perScholas.StockWatchListApplication.model.Stock;
import com.perScholas.StockWatchListApplication.model.Watchlist;
import com.perScholas.StockWatchListApplication.repository.StockRepository;
import com.perScholas.StockWatchListApplication.repository.WatchlistRepository;
import com.perScholas.StockWatchListApplication.service.Interface.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private WatchlistRepository watchlistRepository;

    @Override
    public Stock addStockToWatchlist(Long watchlistId, Stock stock) {
        Watchlist watchlist = watchlistRepository.findById(watchlistId)
                .orElseThrow(() -> new RuntimeException("Watchlist not found"));
        stock.setWatchlist(watchlist);
        return stockRepository.save(stock);
    }

    @Override
    public List<Stock> getStocksByWatchlist(Long watchlistId) {
        Watchlist watchlist = watchlistRepository.findById(watchlistId)
                .orElseThrow(() -> new RuntimeException("Watchlist not found"));
        return watchlist.getStocks();
    }

    @Override
    public void deleteStock(Long id) {
        if (!stockRepository.existsById(id)) {
            throw new RuntimeException("Stock not found");
        }
        stockRepository.deleteById(id);
    }
    @Override
    public Optional<Stock> getStockById(Long id) {
        return stockRepository.findById(id);
    }

    @Override
    public void updateStock(Stock stock) {
        stockRepository.save(stock);
    }
}