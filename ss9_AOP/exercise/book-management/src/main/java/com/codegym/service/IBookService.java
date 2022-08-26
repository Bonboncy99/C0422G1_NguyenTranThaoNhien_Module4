package com.codegym.service;

import com.codegym.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
    void update(Book book);
    Book findById(int id);
}
