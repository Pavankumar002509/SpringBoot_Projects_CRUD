package com.example.library.controller;

import com.example.library.model.Book;
import com.example.library.service.BookService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping
    public Book addBook(@Valid @RequestBody Book book) {
        return service.addBook(book);
    }

    @GetMapping("/{id}")
    public Book searchBookById(@PathVariable Long id) {
        return service.searchBookById(id);
    }

    @PatchMapping("/{id}/availability")
    public Book updateAvailability(@PathVariable Long id,
                                   @RequestBody Map<String, Boolean> request) {
        return service.updateAvailability(id, request.get("available"));
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        return service.deleteBook(id) ? "Book deleted successfully" : "Book not found";
    }
}
