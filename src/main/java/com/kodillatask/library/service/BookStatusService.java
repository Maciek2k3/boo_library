package com.kodillatask.library.service;

import com.kodillatask.library.domian.*;
import com.kodillatask.library.repository.BookStatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookStatusService {

    public BookStatusService(BookStatusRepository bookStatusRepository) {
        this.bookStatusRepository = bookStatusRepository;
    }

    public final BookStatusRepository bookStatusRepository;

   public List<BookAvailable> findAllBookStatud() {
        return bookStatusRepository.countAvailableCopies();
    }
}

