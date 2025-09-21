package com.library.Library_Management_System.mapper;

import com.library.Library_Management_System.entity.Book;
import com.library.Library_Management_System.dto.BookDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookDTO toDto(Book book);
    Book toEntity(BookDTO dto);
}
