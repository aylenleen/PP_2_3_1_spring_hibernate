package org.example.service;

import org.example.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void add(User user);
    void update(User user);
    void delete(User user);

}
