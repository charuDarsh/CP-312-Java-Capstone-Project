package com.perScholas.StockWatchListApplication.model;

import lombok.Data;
import lombok.NonNull;


@Data
public class Login {
    @NonNull
    private String username;
    @NonNull
    private String password;
}
