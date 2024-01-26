package edu.icet.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.dto.Book;
import edu.icet.entity.BookEntity;
import edu.icet.repository.BookRepository;
import edu.icet.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
    public List<Book> getAllBooks(){
        List<Book> list = new ArrayList<>();

        Iterable<BookEntity> studentList = bookRepository.findAll();

        Iterator<BookEntity> iterator = studentList.iterator();


        while(iterator.hasNext()){
            BookEntity bookEntity = iterator.next();
            Book book = objectMapper.convertValue(bookEntity, Book.class);
            list.add(book);
        }

        return list;
    }

    public Book SearchBook(String title){
        List<Book> list = getAllBooks();
        for (Book book:list) {
            if (title.equals(book.getTitle())){
                return book;
            }
        }
        return null;
    }

}
