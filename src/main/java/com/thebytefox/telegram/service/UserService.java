package com.thebytefox.telegram.service;

import com.thebytefox.telegram.model.User;
import com.thebytefox.telegram.repository.JpaUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final JpaUserRepository userRepository;

    public UserService(JpaUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getOrCreate(int chatId) {
        return get(chatId)
                .orElseGet(() -> userRepository.save(new User(chatId)));
    }

    public Optional<User> get(int chatId) {
        return userRepository.getByChatId(chatId);
    }

    public User update(User user) {
        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
