package com.example.demo.Controller;

import com.example.demo.Service.bookService;
import com.example.demo.entity.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    private bookService bs;




    @Autowired
    public BookController(bookService bs) {
        this.bs = bs;
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }


    @GetMapping("/showAll")
    public String show(Model model){
        List<Book>books =bs.findAll();
        model.addAttribute("books",books);

        return "list";
    }
    @GetMapping("/add")
    public String add(Model model){

        Book book=new Book();
        model.addAttribute("book",book);
        return "addBook";
    }

    @PostMapping("/save")
    public String addBook( @RequestParam("id") int id,
                          @RequestParam("name") String name,
                          @RequestParam("author") String author,
                          @RequestParam("file") MultipartFile picture) throws IOException {
        Book bk=bs.findById(id);
        if(bk!=null){
            bk.setName(name);
            bk.setAuthor(author);
            bk.setImage(picture.getOriginalFilename());
            bs.save(bk);
        }else {
            Book book = new Book();
            book.setId(id);
            book.setName(name);
            book.setAuthor(author);
            // Here you would handle the file upload, saving it somewhere accessible and store the URL in the book entity
            // For simplicity, let's just store the filename
            book.setImage(picture.getOriginalFilename());
            bs.save(book);
        }
        return "redirect:/showAll";
    }
    @GetMapping("/update")
    public String update(@RequestParam("id")int id,Model model){
     Book b=bs.findById(id);
     model.addAttribute("book",b);
     return "addBook";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("id")int id,Model model){

        bs.delete(id);
        return "redirect:/showAll";
    }





    @GetMapping("/login")
    public String logIn(){

        return "login";
    }

    @GetMapping("/users")
    public String list(){
        return "redirect:/showAll";
    }
    @GetMapping("/admin")
    public String listAdmin(){
        return "list";
    }


}
