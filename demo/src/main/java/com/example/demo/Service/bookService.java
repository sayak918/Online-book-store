package com.example.demo.Service;

import com.example.demo.entity.Book;


import java.util.List;

public interface bookService {
    List<Book> findAll();
    Book findById(int id);

    void save(Book book);
    void delete(int id);

}
