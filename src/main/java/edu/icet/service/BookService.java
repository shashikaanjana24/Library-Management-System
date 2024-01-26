package edu.icet.service;

import edu.icet.dto.Book;

import java.util.List;

public interface BookService {
    public void addBook(Book book);
    public List<Book> getAllBooks();
    public Book SearchBook(String title);
}
