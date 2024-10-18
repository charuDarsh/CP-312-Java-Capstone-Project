package com.perScholas.StockWatchListApplication.service.Interface;

import com.perScholas.StockWatchListApplication.model.User;

import java.util.Optional;

public interface UserService {
    User registerUser(User user);
    User loginUser(String email, String password);
    Optional<User> findUserByEmail(String email);
}
