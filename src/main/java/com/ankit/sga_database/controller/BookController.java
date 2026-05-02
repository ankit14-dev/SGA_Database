package com.ankit.sga_database.controller;

import com.ankit.sga_database.model.Author;
import com.ankit.sga_database.model.Book;
import com.ankit.sga_database.service.AuthorService;
import com.ankit.sga_database.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;

    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping({"/","/books"})
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.findAll());
        model.addAttribute("joinRows", bookService.fetchBookAuthorJoin());
        return "list";
    }

    @GetMapping("/books/new")
    public String showCreateForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("authors", authorService.findAll());
        return "create";
    }

    @PostMapping("/books")
    public String createBook(@ModelAttribute Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("authors", authorService.findAll());
            return "create";
        }
        try {
            bookService.save(book);
        } catch (Exception ex) {
            result.reject("error", "Could not save book: " + ex.getMessage());
            model.addAttribute("authors", authorService.findAll());
            return "create";
        }
        return "redirect:/books";
    }

    @GetMapping("/books/edit/{id}")
    public String showEdit(@PathVariable Long id, Model model) {
        Book b = bookService.findById(id);
        if (b == null) return "redirect:/books";
        model.addAttribute("book", b);
        model.addAttribute("authors", authorService.findAll());
        return "edit";
    }

    @PostMapping("/books/update/{id}")
    public String updateBook(@PathVariable Long id, @ModelAttribute Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("authors", authorService.findAll());
            return "edit";
        }
        Book existing = bookService.findById(id);
        if (existing == null) return "redirect:/books";
        existing.setTitle(book.getTitle());
        existing.setIsbn(book.getIsbn());
        existing.setAuthor(book.getAuthor());
        bookService.save(existing);
        return "redirect:/books";
    }
}
