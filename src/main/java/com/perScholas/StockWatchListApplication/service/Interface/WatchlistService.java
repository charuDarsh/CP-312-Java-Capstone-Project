package com.perScholas.StockWatchListApplication.service.Interface;

import com.perScholas.StockWatchListApplication.model.Watchlist;

import java.util.List;

public interface WatchlistService {
    Watchlist createWatchlist(Long userId, Watchlist watchlist);

    List<Watchlist> getWatchlistsByUser(Long userId);

    void deleteWatchlist(Long id);

    //  Object  getAllWatchlists();
    List<Watchlist> getAllWatchlists();

    Watchlist saveWatchlist(Watchlist watchlist);

}


