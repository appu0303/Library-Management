package com.library.Library_Management_System.service;

import com.library.Library_Management_System.dto.BookDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {

    BookDTO createBook(BookDTO bookDTO);
    BookDTO getBookById(int id);
    List<BookDTO> getAllBooks();
    BookDTO updateBook(int id, BookDTO bookDTO);
    void deleteBook(int id);

}
