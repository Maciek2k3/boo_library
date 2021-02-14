package com.kodillatask.library.service;

import com.kodillatask.library.domian.Books;
import com.kodillatask.library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksService {

    public final BookRepository bookRepository;

    public BooksService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Books> findAllBooks() {
        return bookRepository.findAll();

    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    public Optional<Books> findBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Books saveBook(final Books books) {
        return bookRepository.save(books);
    }
}
