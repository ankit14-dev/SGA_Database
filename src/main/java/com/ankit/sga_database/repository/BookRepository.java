package com.ankit.sga_database.repository;

import com.ankit.sga_database.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b.title, b.isbn, a.name FROM Book b INNER JOIN b.author a")
    List<Object[]> fetchBookAuthorInnerJoin();
}
