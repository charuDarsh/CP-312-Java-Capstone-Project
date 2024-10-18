package com.perScholas.StockWatchListApplication.Controller;
import com.perScholas.StockWatchListApplication.controller.WatchlistController;
import com.perScholas.StockWatchListApplication.model.User;
import com.perScholas.StockWatchListApplication.model.Watchlist;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
public class WatchlistControllerTest {
    @InjectMocks
    private WatchlistController watchlistController;

    @Mock
    private WatchlistService watchlistService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(watchlistController).build();
    }


    @Test
    public void testCreateWatchlist() throws Exception {
        Long userId = 1L;
        String watchlistName = "New Watchlist";

        mockMvc.perform(post("/watchlists/create")
                        .param("userId", String.valueOf(userId))
                        .param("name", watchlistName))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/watchlists?userId=" + userId));

        verify(watchlistService, times(1)).createWatchlist(eq(userId), any(Watchlist.class));
    }

    @Test
    public void testDeleteWatchlist() throws Exception {
        Long watchlistId = 1L;
        Long userId = 1L;

        mockMvc.perform(post("/watchlists/{id}", watchlistId)
                        .param("userId", String.valueOf(userId)))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/watchlists?userId=" + userId));

        verify(watchlistService, times(1)).deleteWatchlist(watchlistId);
    }
}

