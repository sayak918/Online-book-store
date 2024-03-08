package com.sayak.demo.controller;

import com.sayak.demo.entity.Book;
import com.sayak.demo.service.bookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DemoController {
    @Autowired
    private bookService bs;




    @Autowired
    public DemoController(bookService bs) {
        this.bs = bs;
    }


    @GetMapping("/")
    public String showHome() {



        return "home";
    }

    // add a request mapping for /leaders

    @GetMapping("/leaders")
    public String showLeaders() {

        return "leaders";
    }

    // add request mapping for /systems

    @GetMapping("/systems")
    public String showSystems() {

        return "systems";
    }
    @GetMapping("/showBooks")
    public String  BookList(Model model){
        List<Book> books =bs.findAll();
        model.addAttribute("books",books);
        return "book-list";
    }

}









