package com.library.Library_Management_System.controller;

import com.library.Library_Management_System.controller.api.BookApi;
import com.library.Library_Management_System.dto.BookDTO;
import com.library.Library_Management_System.service.BookService;
//import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequiredArgsConstructor
public class BookController implements BookApi {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @Override
    public ResponseEntity<BookDTO> createBook(BookDTO bookDTO) {
        return ResponseEntity.ok(bookService.createBook(bookDTO));
    }

    @Override
    public ResponseEntity<BookDTO> getBookById(int id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @Override
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @Override
    public ResponseEntity<BookDTO> updateBook(int id, BookDTO bookDTO) {
        return ResponseEntity.ok(bookService.updateBook(id,bookDTO));
    }

    @Override
    public ResponseEntity<Void> deleteBook(int id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
