package com.library.Library_Management_System.controller.api;

import com.library.Library_Management_System.dto.BookDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Book API", description = "CRUD operations for books")
@RequestMapping("/api/books")
public interface BookApi {

    @Operation(summary = "Create a new book")
    @PostMapping
    ResponseEntity<BookDTO> createBook(@RequestBody BookDTO bookDTO);

    @Operation(summary = "Get a book by ID")
    @GetMapping("/{id}")
    ResponseEntity<BookDTO> getBookById(@PathVariable int id);

    @Operation(summary = "Get all books")
    @GetMapping
    ResponseEntity<List<BookDTO>> getAllBooks();

    @Operation(summary = "Update a book by ID")
    @PutMapping("/{id}")
    ResponseEntity<BookDTO> updateBook(@PathVariable int id, @RequestBody BookDTO bookDTO);

    @Operation(summary = "Delete a book by ID")
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteBook(@PathVariable int id);

}
