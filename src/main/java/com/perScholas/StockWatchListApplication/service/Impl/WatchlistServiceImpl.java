package com.perScholas.StockWatchListApplication.service.Impl;

import com.perScholas.StockWatchListApplication.model.User;
import com.perScholas.StockWatchListApplication.model.Watchlist;
import com.perScholas.StockWatchListApplication.repository.UserRepository;
import com.perScholas.StockWatchListApplication.repository.WatchlistRepository;
import com.perScholas.StockWatchListApplication.service.Interface.WatchlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatchlistServiceImpl implements WatchlistService {

    @Autowired
    private WatchlistRepository watchlistRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Watchlist createWatchlist(Long userId, Watchlist watchlist) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        watchlist.setUser(user);
        return watchlistRepository.save(watchlist);
    }

    @Override
    public List<Watchlist> getWatchlistsByUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return user.getWatchlists();
    }

    @Override
    public void deleteWatchlist(Long id) {
        if (!watchlistRepository.existsById(id)) {
            throw new RuntimeException("Watchlist not found");
        }
        watchlistRepository.deleteById(id);
    }

    @Override
    public List<Watchlist> getAllWatchlists() {
        return watchlistRepository.findAll();

    }

    @Override
    public Watchlist saveWatchlist(Watchlist watchlist) {
         watchlistRepository.save(watchlist);
        return watchlist;
    }





}


