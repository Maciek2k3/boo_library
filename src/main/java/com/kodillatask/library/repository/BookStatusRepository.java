package com.kodillatask.library.repository;

import com.kodillatask.library.domian.BookAvailable;
import com.kodillatask.library.domian.BookStatus;
import com.kodillatask.library.domian.BookStatusDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.List;

@Repository
public interface BookStatusRepository extends CrudRepository<BookStatus, Long> {


    @Query(value = "select books.id as id, books.title as title, count(copy.book_id) as copyAvailable from books\n" +
            "join copy on copy.book_id = books.id\n" +
            "where copy.status = 'available'\n" +
            "group by copy.book_id;",
          nativeQuery = true)
    List<BookAvailable> countAvailableCopies();
}


