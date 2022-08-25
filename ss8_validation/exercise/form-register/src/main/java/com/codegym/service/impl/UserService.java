package com.codegym.service.impl;

import com.codegym.model.User;
import com.codegym.repository.IUserRepository;
import com.codegym.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public List<User> findAll() {
        return this.iUserRepository.findAll();
    }

    @Override
    public void add(User user) {
        this.iUserRepository.save(user);
    }

    @Override
    public void update(User user) {
        this.iUserRepository.save(user);
    }

    @Override
    public void delete(int id) {
        this.iUserRepository.deleteById(id);
    }

    @Override
    public Optional<User> findById(int id) {
        return this.iUserRepository.findById(id);
    }
}
