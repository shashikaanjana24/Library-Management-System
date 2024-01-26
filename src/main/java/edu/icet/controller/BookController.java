package edu.icet.controller;

import edu.icet.dto.Book;
import edu.icet.entity.BookEntity;
import edu.icet.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;
    @GetMapping("/add")
    public void add(@RequestBody Book book){
        bookService.addBook(book);
    }

    @GetMapping("/view")
    public List<Book>viewAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/search")
    public Book searchBook(@RequestBody Book book){
        return bookService.SearchBook(book.getTitle());
    }
}
