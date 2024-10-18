package com.perScholas.StockWatchListApplication.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.antlr.v4.runtime.misc.NotNull;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Watchlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String name;

    @ManyToOne // relationship with the User entity, where multiple watchlists can belong to one user.
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "watchlist", cascade = CascadeType.ALL) // Indicates a one-to-many relationship with Stock, where a watchlist can contain multiple stocks.
    private List<Stock> stocks;



}
