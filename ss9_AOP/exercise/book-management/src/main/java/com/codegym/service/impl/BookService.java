package com.codegym.service.impl;

import com.codegym.model.Book;
import com.codegym.repository.IBookRepository;
import com.codegym.service.IBookService;
import com.common.BookNotFoundException;
import com.common.OutOfBookException;
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
    public Book findById(int id) {
        return this.iBookRepository.findById(id).orElse(null);
    }

    @Override
    public boolean borrowBook(Book book) throws Exception {
        if (book == null) {
            throw new BookNotFoundException();
        } else {
            if (book.getRemainingQuantity() == 0) {
                throw new OutOfBookException();
            } else {
                book.setRemainingQuantity(book.getRemainingQuantity() - 1);
                this.iBookRepository.save(book);
                return true;
            }
        }
    }

    @Override
    public boolean giveBack(Book book) throws Exception {
        if (book == null){
            throw new BookNotFoundException();
        } else {
            if (book.getRemainingQuantity()==book.getQuantity()){
                throw new BookNotFoundException();
            } else {
                book.setRemainingQuantity(book.getRemainingQuantity()+1);
                this.iBookRepository.save(book);
                return true;
            }
        }
    }

}
