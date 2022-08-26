package com.codegym.service.impl;

import com.codegym.model.Book;
import com.codegym.repository.IBookRepository;
import com.codegym.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository iBookRepository;
    @Override
    public List<Book> findAll() {
        return this.iBookRepository.findAll();
    }

    @Override
    public void update(Book book) {
        this.iBookRepository.save(book);
    }

    @Override
    public Book findById(int id) {
        return this.iBookRepository.findById(id).orElse(null);
    }
}
