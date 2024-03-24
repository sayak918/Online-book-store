package com.example.demo.dao;




import com.example.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;



public interface bookRepository extends JpaRepository<Book,Integer>
{
}
