package com.codegym.controller;

import com.codegym.model.Book;
import com.codegym.repository.IBookRepository;
import com.codegym.service.IBookService;
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
        String messBorrow="";
        Book book = this.iBookService.findById(id);
        int remainingQuantity = book.getRemainingQuantity();
        if (remainingQuantity > 0) {
            book.setRemainingQuantity(remainingQuantity - 1);
            this.iBookService.update(book);
            messBorrow = "Đã mượn sách hành công";
        }  else {
            throw new Exception();
        }
        model.addAttribute("messBorrow", messBorrow);
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
        String messGiveBack;
        Book book = this.iBookService.findById(idBook);
        int remainingQuantity;
        int quantity;
        if (book==null){
           throw new Exception();
        } else {
            remainingQuantity = book.getRemainingQuantity();
            quantity = book.getQuantity();
            if (remainingQuantity == quantity) {
                    throw new Exception();
            } else {
                book.setRemainingQuantity(remainingQuantity + 1);
                this.iBookService.update(book);
                messGiveBack = "Trả sách thành công";
            }
        }
        model.addAttribute("messGiveBack",messGiveBack);
        return "giveback";
    }
    @ExceptionHandler(value = Exception.class)
    public String goToBookError() {
            return "notfound";
    }
}
