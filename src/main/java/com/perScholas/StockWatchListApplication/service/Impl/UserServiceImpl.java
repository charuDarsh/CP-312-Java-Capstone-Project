package com.perScholas.StockWatchListApplication.service.Impl;

import com.perScholas.StockWatchListApplication.model.User;
import com.perScholas.StockWatchListApplication.repository.UserRepository;
import com.perScholas.StockWatchListApplication.service.Interface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        userRepository.save(user); // Save user to the database
        return user;
    }

    @Override
    public User loginUser(String email, String password) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return user.orElse(null);
        }
        throw new RuntimeException("Invalid email or password");
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
