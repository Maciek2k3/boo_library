package com.kodillatask.library;

import com.kodillatask.library.domian.Books;
import com.kodillatask.library.repository.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.print.Book;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestDbo {
    @Autowired
    BookRepository bookRepository;

    @Test
    public void givenStudent_whenSave_thenGetOk() {
        Books book = new Books(1l,"no","no",LocalDate.now());
        bookRepository.save(book);
        List<Books> booksList=bookRepository.findAll();

        assertEquals(1, booksList.size());
    }

}
