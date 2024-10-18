package com.perScholas.StockWatchListApplication.controller;

import com.perScholas.StockWatchListApplication.model.Watchlist;

import com.perScholas.StockWatchListApplication.service.Interface.WatchlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/watchlists")
public class WatchlistController {

    @Autowired
    private WatchlistService watchlistService;

    @GetMapping
    public String getWatchlists(@RequestParam Long userId, Model model) {
        List<Watchlist> watchlists = watchlistService.getWatchlistsByUser(userId);
        model.addAttribute("watchlists", watchlists);
        model.addAttribute("userId", userId);
        return "watchlists";
    }

    @PostMapping("/create")
    public String createWatchlist(@RequestParam Long userId, @RequestParam String name) {
        Watchlist watchlist = new Watchlist();
        watchlist.setName(name);
        watchlistService.createWatchlist(userId, watchlist);
        return "redirect:/watchlists?userId=" + userId;
    }


    @PostMapping("/{id}")
    public String deleteWatchlist(@PathVariable Long id, @RequestParam Long userId) {
        watchlistService.deleteWatchlist(id);
        return "redirect:/watchlists?userId=" + userId;
    }


}


//@Controller
//@RequestMapping("/watchlists")
//public class WatchlistController {
//
//    @Autowired
//    private WatchlistService watchlistService;
//
//    @GetMapping
//    public String getWatchlists(@RequestParam Long userId, Model model) {
//        List<Watchlist> watchlists = watchlistService.getWatchlistsByUser(userId);
//        model.addAttribute("watchlists", watchlists);
//        return "watchlists";
//    }
//    @GetMapping("/watchlists")
//    public String showWatchlists(Model model) {
//        model.addAttribute("watchlists", watchlistService.getAllWatchlists());
//        model.addAttribute("watchlist", new Watchlist());
//        return "watchlists"; // Returns the Thymeleaf template
//    }
//
//    @PostMapping("/create")
//    public String createWatchlist(@RequestParam Long userId, @RequestParam String name) {
//        Watchlist watchlist = new Watchlist();
//        watchlist.setName(name);
//        watchlistService.createWatchlist(userId, watchlist);
//        return "redirect:/watchlists?userId=" + userId;
//    }
//    @PostMapping("/watchlists")
//    public String addWatchlist(@ModelAttribute("watchlist") Watchlist watchlist) {
//        watchlistService.saveWatchlist(watchlist);
//        return "redirect:/watchlists"; // Redirect to the watchlists page after successful submission
//    }
//    @PostMapping("/{id}")
//    public String deleteWatchlist(@PathVariable Long id, @RequestParam Long userId) {
//        watchlistService.deleteWatchlist(id);
//        return "redirect:/watchlists?userId=" + userId;
//    }
//}
//@RestController
//@RequestMapping("/api/watchlists")
//public class WatchlistController {
//
//    @Autowired
//    private WatchlistService watchlistService;
//
//    @PostMapping("/create")
//    public ResponseEntity<Watchlist> createWatchlist(@RequestParam Long userId, @RequestBody Watchlist watchlist) {
//        try {
//            Watchlist savedWatchlist = watchlistService.createWatchlist(userId, watchlist);
//            return new ResponseEntity<>(savedWatchlist, HttpStatus.CREATED);
//        } catch (RuntimeException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @GetMapping("/{userId}")
//    public ResponseEntity<List<Watchlist>> getWatchlistsByUser(@PathVariable Long userId) {
//        try {
//            List<Watchlist> watchlists = watchlistService.getWatchlistsByUser(userId);
//            return new ResponseEntity<>(watchlists, HttpStatus.OK);
//        } catch (RuntimeException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteWatchlist(@PathVariable Long id) {
//        try {
//            watchlistService.deleteWatchlist(id);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } catch (RuntimeException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//}