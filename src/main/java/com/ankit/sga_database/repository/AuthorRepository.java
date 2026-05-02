package com.ankit.sga_database.repository;

import com.ankit.sga_database.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
