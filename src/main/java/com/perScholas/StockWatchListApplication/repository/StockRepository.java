package com.perScholas.StockWatchListApplication.repository;

import com.perScholas.StockWatchListApplication.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock,Long> {
   // List<Stock> findBySymbol(String symbol);
  //  List<Stock> findByWatchlistId(Long watchlistId);
}
