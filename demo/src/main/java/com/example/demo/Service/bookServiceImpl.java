package com.example.demo.Service;


import com.example.demo.dao.bookRepository;
import com.example.demo.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class bookServiceImpl implements bookService{
    private bookRepository bookrepository;

    @Autowired

    public bookServiceImpl(bookRepository bookrepository) {
        this.bookrepository = bookrepository;
    }

    @Override
    public List<Book>findAll() {
        return bookrepository.findAll();
    }


    @Override
    public Book findById(int id) {
        Optional<Book>result=bookrepository.findById(id);
        Book book=null;
        if(result.isPresent()){
            book=result.get();
        }else{
            throw new RuntimeException("Book not found" + id);
        }

        return book;
    }

    @Override
    public void save(Book book) {

        bookrepository.save(book);
    }

    @Override
    public void delete(int id) {
        Book b=findById(id);
        bookrepository.delete(b);

    }

}
