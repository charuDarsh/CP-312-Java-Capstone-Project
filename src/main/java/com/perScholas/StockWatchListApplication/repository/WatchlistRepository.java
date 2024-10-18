package com.perScholas.StockWatchListApplication.repository;

import com.perScholas.StockWatchListApplication.model.Watchlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WatchlistRepository extends JpaRepository<Watchlist,Long> {
  //  List<Watchlist> findByUserId(Long userId);
}
