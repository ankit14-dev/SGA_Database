package com.ankit.sga_database.service;

import com.ankit.sga_database.model.Author;
import com.ankit.sga_database.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> findAll() { return authorRepository.findAll(); }
    public Author save(Author a) { return authorRepository.save(a); }
    public Author findById(Long id) { return authorRepository.findById(id).orElse(null); }
}
