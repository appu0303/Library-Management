package com.library.Library_Management_System.service.impl;

import com.library.Library_Management_System.dto.BookDTO;
import com.library.Library_Management_System.entity.Book;
import com.library.Library_Management_System.exception.ResourceNotFoundException;
import com.library.Library_Management_System.mapper.BookMapper;
import com.library.Library_Management_System.repository.BookRepository;
import com.library.Library_Management_System.service.BookService;
//import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
//@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public BookDTO createBook(BookDTO bookDTO) {

        Book book = bookMapper.toEntity(bookDTO);
        return bookMapper.toDto(bookRepository.save(book));
    }

    @Override
    public BookDTO getBookById(int id) {

      return bookRepository.findById(id).map(bookMapper::toDto)
              .orElseThrow(()->new ResourceNotFoundException("Book not found with id : "+id));
    }

    @Override
    public List<BookDTO> getAllBooks() {

        return bookRepository.findAll()
                .stream().
                map(bookMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public BookDTO updateBook(int id, BookDTO bookDTO) {

        Book book = bookRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Book not found with id : "+id));

        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setCategory(bookDTO.getCategory());
        book.setAvailableCopies(bookDTO.getAvailableCopies());
        book.setTotalCopies(bookDTO.getTotalCopies());

        return bookMapper.toDto(bookRepository.save(book));
    }

    @Override
    public void deleteBook(int id) {

        if(!bookRepository.existsById(id))
        {
            throw new ResourceNotFoundException("Book not found with is : "+id);
        }
        bookRepository.deleteById(id);
    }
}
