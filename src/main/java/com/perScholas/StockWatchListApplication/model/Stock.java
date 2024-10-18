package com.perScholas.StockWatchListApplication.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.lang.NonNull;

import java.util.Objects;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity  // Indicates that this is a JPA entity and maps to a database table.
public class Stock {
    @Id //  Specifies the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // how it should be generated (auto-incremented).
    private Long id;

    @NotNull
    private String symbol;

    @NotNull
    private String name;
    @NotNull
    private double price;

    @ManyToOne // Represents a many-to-one relationship with the Watchlist entity
    @JoinColumn(name = "watchlist_id") // specifies the foreign key in the database.
    private Watchlist watchlist;


}
