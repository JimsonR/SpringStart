package com.myApp.Mine.repository;

import com.myApp.Mine.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book,Integer> {
}


