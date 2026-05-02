package com.ankit.sga_database.service;

import com.ankit.sga_database.model.Book;
import com.ankit.sga_database.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll() { return bookRepository.findAll(); }
    public Book save(Book b) { return bookRepository.save(b); }
    public Book findById(Long id) { return bookRepository.findById(id).orElse(null); }
    public List<Object[]> fetchBookAuthorJoin() { return bookRepository.fetchBookAuthorInnerJoin(); }
}
