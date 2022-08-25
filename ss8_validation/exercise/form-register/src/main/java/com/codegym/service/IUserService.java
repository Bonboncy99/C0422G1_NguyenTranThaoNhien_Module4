package com.codegym.service;

import com.codegym.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List <User> findAll();
    void add (User user);
    void update (User user);
    void delete (int id);
    Optional<User> findById(int id);

}
