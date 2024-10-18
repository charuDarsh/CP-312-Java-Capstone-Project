package com.perScholas.StockWatchListApplication.model;

import jakarta.persistence.*;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NonNull
  private String name;


  @NonNull
  private String email;
  @NonNull
  private String password;

  //specifies that the user field in the Watchlist class is the owner of the relationship.
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL) //Indicates a one-to-many relationship with the Watchlist
  //cascade property ensures that any changes made to the user are propagated to the related watchlists.
  private List<Watchlist> watchlists = new ArrayList<>();;





}
