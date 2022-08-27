package com.codegym.controller;

import com.codegym.model.Book;
import com.codegym.repository.IBookRepository;
import com.codegym.service.IBookService;
import com.common.BookNotFoundException;
import com.common.OutOfBookException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private IBookService iBookService;

    @GetMapping("/")
    public String goToList(Model model) {
        model.addAttribute("bookList", this.iBookService.findAll());
        return "list";
    }

    @GetMapping("/detail")
    public String goToDetail(@RequestParam("id") int id, Model model) {
        model.addAttribute("book", this.iBookService.findById(id));
        return "detail";
    }

    @GetMapping("/borrow")
    public String borrow(@RequestParam("id") int id, Model model) throws Exception {
        Book book = this.iBookService.findById(id);
        if (this.iBookService.borrowBook(book)){
            model.addAttribute("messBorrow", "Mượn sách thành công");
        }
        model.addAttribute("id", id);
        model.addAttribute("book", book);
        return "detail";
    }

    @GetMapping("/giveback")
    public String goToGiveBack(){
        return "giveback";
    }

    @PostMapping("/giveback")
    public String giveBack(@RequestParam("idBook") int idBook, Model model) throws Exception {
        Book book = this.iBookService.findById(idBook);
        if (this.iBookService.giveBack(book)){
            model.addAttribute("messGiveBack","Trả sách thành công");
        }
        return "giveback";
    }

    @ExceptionHandler(value = BookNotFoundException.class)
    public String goToNotFound(Model model) {
        model.addAttribute("mess","Book not found");
        return "bookerror";
    }
    @ExceptionHandler(value = OutOfBookException.class)
    public String goToOutOfBook(Model model) {
        model.addAttribute("mess","Out of book");
        return "bookerror";
    }
}
