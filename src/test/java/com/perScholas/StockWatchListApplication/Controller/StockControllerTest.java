package com.perScholas.StockWatchListApplication.Controller;
import com.perScholas.StockWatchListApplication.controller.StockController;
import com.perScholas.StockWatchListApplication.model.Stock;
import com.perScholas.StockWatchListApplication.service.Interface.StockService;
import com.perScholas.StockWatchListApplication.service.Interface.WatchlistService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
public class StockControllerTest {
    @InjectMocks
    private StockController stockController;

    @Mock
    private StockService stockService;

    @Mock
    private WatchlistService watchlistService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(stockController).build();
    }

    @Test
    public void testGetStocksByWatchlist() throws Exception {
        Long watchlistId = 1L;

        List<Stock> stocks = Arrays.asList(
                new Stock(1L, "AAPL", "Apple Inc.", 150.0, null),
                new Stock(2L, "GOOGL", "Alphabet Inc.", 2800.0, null)
        );

        when(stockService.getStocksByWatchlist(watchlistId)).thenReturn(stocks);

        mockMvc.perform(get("/stocks/{watchlistId}", watchlistId))
                .andExpect(status().isOk())
                .andExpect(view().name("stocks"))
                .andExpect(model().attributeExists("stocks"))
                .andExpect(model().attributeExists("watchlistId"));

        verify(stockService, times(1)).getStocksByWatchlist(watchlistId);
    }

    @Test
    public void testAddStockToWatchlist() throws Exception {
        Long watchlistId = 1L;
        String symbol = "AAPL";
        String name = "Apple Inc.";

        mockMvc.perform(post("/stocks/add")
                        .param("watchlistId", String.valueOf(watchlistId))
                        .param("symbol", symbol)
                        .param("name", name))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/stocks/" + watchlistId));

        verify(stockService, times(1)).addStockToWatchlist(eq(watchlistId), any(Stock.class));
    }

    @Test
    public void testDeleteStock() throws Exception {
        Long watchlistId = 1L;
        Long stockId = 1L;

        mockMvc.perform(post("/stocks/{id}", stockId)
                        .param("watchlistId", String.valueOf(watchlistId)))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/stocks/" + watchlistId));

        verify(stockService, times(1)).deleteStock(stockId);
    }

    @Test
    public void testShowEditStockForm() throws Exception {
        Long watchlistId = 1L;
        Long stockId = 1L;
        Stock stock = new Stock(stockId, "AAPL", "Apple Inc.", 150.0, null);

        when(stockService.getStockById(stockId)).thenReturn(Optional.of(stock));

        mockMvc.perform(get("/stocks/{watchlistId}/edit/{stockId}", watchlistId, stockId))
                .andExpect(status().isOk())
                .andExpect(view().name("editStock"))
                .andExpect(model().attributeExists("stock"))
                .andExpect(model().attributeExists("watchlistId"));

        verify(stockService, times(1)).getStockById(stockId);
    }

    @Test
    public void testUpdateStock() throws Exception {
        Long watchlistId = 1L;
        Long stockId = 1L;
        String updatedSymbol = "AAPL";
        String updatedName = "Apple Inc. Updated";

        Stock existingStock = new Stock(stockId, "AAPL", "Apple Inc.", 150.0, null);
        when(stockService.getStockById(stockId)).thenReturn(Optional.of(existingStock));

        mockMvc.perform(post("/stocks/{watchlistId}/edit/{stockId}", watchlistId, stockId)
                        .param("symbol", updatedSymbol)
                        .param("name", updatedName))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/stocks/" + watchlistId));

        verify(stockService, times(1)).updateStock(any(Stock.class));
    }
}
