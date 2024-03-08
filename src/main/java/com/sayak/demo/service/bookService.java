package com.sayak.demo.service;


import com.sayak.demo.entity.Book;

import java.util.List;

public interface bookService {
    List<Book> findAll();
    Book findById(int id);

    void save(Book book);
    void delete(int id);

}
