package com.sayak.demo.dao;




import com.sayak.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface bookRepository extends JpaRepository<Book,Integer>
{
}
