package com.perScholas.StockWatchListApplication.controller;

import com.perScholas.StockWatchListApplication.model.Stock;
import com.perScholas.StockWatchListApplication.service.Interface.StockService;
import com.perScholas.StockWatchListApplication.service.Interface.WatchlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    @Autowired
    private WatchlistService watchlistService;

  //  private Long userId ;

    @GetMapping("/{watchlistId}")
    public String getStocksByWatchlist(@PathVariable Long watchlistId, Model model) {
        List<Stock> stocks = stockService.getStocksByWatchlist(watchlistId);
        model.addAttribute("stocks", stocks);
        model.addAttribute("watchlistId", watchlistId);
        return "stocks"; // Render the Thymeleaf template for displaying stocks
    }

    @GetMapping("{userId}/{watchlistId}")
    public String getStocksByWatchlist2(@PathVariable Long userId,@PathVariable Long watchlistId, Model model) {
        List<Stock> stocks = stockService.getStocksByWatchlist(watchlistId);
        model.addAttribute("stocks", stocks);
        model.addAttribute("watchlistId", watchlistId);
        model.addAttribute("userId", userId);
        return "stocks"; // Render the Thymeleaf template for displaying stocks
    }


//    @PostMapping("/add")
//    public String addStockToWatchlist(@RequestParam Long watchlistId, @RequestParam String symbol, @RequestParam String name) {
//        Stock stock = new Stock();
//        stock.setSymbol(symbol);
//        stock.setName(name);
//        stockService.addStockToWatchlist(watchlistId, stock);
//        return "redirect:/stocks/" + watchlistId; // Redirect back to the stocks page
//    }
    @PostMapping("/add")
    public String addStockToWatchlist(@RequestParam Long userId,@RequestParam Long watchlistId, @RequestParam String symbol) {
        Stock stock = new Stock();
        stock.setSymbol(symbol);
        //stock.setName(name);
        stockService.addStockToWatchlist(watchlistId, stock);
        return "redirect:/stocks/"+ userId + "/" + watchlistId; // Redirect back to the stocks page
    }

    @PostMapping("/{id}")
    public String deleteStock(@PathVariable Long id,@RequestParam Long userId, @RequestParam Long watchlistId) {
        stockService.deleteStock(id);
        return "redirect:/stocks/"+ userId +"/" + watchlistId; // Redirect back to the stocks page after deletion
    }
    @GetMapping("/{userId}/{watchlistId}/edit/{stockId}")
    public String showEditStockForm(@PathVariable Long userId, @PathVariable Long watchlistId, @PathVariable Long stockId, Model model) {
        Optional<Stock> stockOptional = stockService.getStockById(stockId);
        if (stockOptional.isPresent()) {
            model.addAttribute("stock", stockOptional.get());
            model.addAttribute("watchlistId", watchlistId);
            model.addAttribute("userId", userId);
            return "editStock"; // Render the Thymeleaf template for editing a stock
        }
        return "redirect:/stocks/"+userId + "/" + watchlistId;
    }
//    @PostMapping("/{watchlistId}/edit/{stockId}")
//    public String updateStock(@PathVariable Long watchlistId, @PathVariable Long stockId, @RequestParam String symbol, @RequestParam String name, RedirectAttributes redirectAttributes) {
//        Optional<Stock> stockOptional = stockService.getStockById(stockId);
//        if (stockOptional.isPresent()) {
//            Stock stock = stockOptional.get();
//            stock.setSymbol(symbol);
//            stock.setName(name);
//            stockService.updateStock(stock);
//            redirectAttributes.addFlashAttribute("message", "Stock updated successfully.");
//        } else {
//            redirectAttributes.addFlashAttribute("error", "Stock not found.");
//        }
//        return "redirect:/stocks/" + watchlistId;
//    }
    @PostMapping("{userId}/{watchlistId}/edit/{stockId}")
    public String updateStock(@PathVariable Long userId,@PathVariable Long watchlistId, @PathVariable Long stockId, @RequestParam String symbol,  RedirectAttributes redirectAttributes) {
        Optional<Stock> stockOptional = stockService.getStockById(stockId);
        if (stockOptional.isPresent()) {
            Stock stock = stockOptional.get();
            stock.setSymbol(symbol);
            stockService.updateStock(stock);
            redirectAttributes.addFlashAttribute("message", "Stock updated successfully.");
        } else {
            redirectAttributes.addFlashAttribute("error", "Stock not found.");
        }
        return "redirect:/stocks/"+userId +"/" + watchlistId;
    }

}

//@RestController
//@RequestMapping("/api/stocks")
//public class StockController {
//
//    @Autowired
//    private StockService stockService;
//
//    @PostMapping("/add")
//    public ResponseEntity<Stock> addStockToWatchlist(@RequestParam Long watchlistId, @RequestBody Stock stock) {
//        try {
//            Stock savedStock = stockService.addStockToWatchlist(watchlistId, stock);
//            return new ResponseEntity<>(savedStock, HttpStatus.CREATED);
//        } catch (RuntimeException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @GetMapping("/{watchlistId}")
//    public ResponseEntity<List<Stock>> getStocksByWatchlist(@PathVariable Long watchlistId) {
//        try {
//            List<Stock> stocks = stockService.getStocksByWatchlist(watchlistId);
//            return new ResponseEntity<>(stocks, HttpStatus.OK);
//        } catch (RuntimeException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteStock(@PathVariable Long id) {
//        try {
//            stockService.deleteStock(id);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } catch (RuntimeException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//}