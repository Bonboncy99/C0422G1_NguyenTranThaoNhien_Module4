package com.codegym.service;

import com.codegym.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
    Book findById(int id);
    boolean borrowBook(Book book) throws Exception;
    boolean giveBack(Book book) throws Exception;
}
