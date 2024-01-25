package edu.icet.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.dto.Book;
import edu.icet.entity.BookEntity;
import edu.icet.repository.BookRepository;
import edu.icet.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    BookRepository bookRepository;
    public void addBook(Book book){
        BookEntity bookEntity =  objectMapper.convertValue(book, BookEntity.class);
        bookRepository.save(bookEntity);
    }
}
