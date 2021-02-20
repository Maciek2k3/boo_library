package com.kodillatask.library;

import com.kodillatask.library.domian.*;
import com.kodillatask.library.repository.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.print.Book;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestServices {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    CopyRepository copyRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    BookStatusRepository bookStatusRepository;


    @Test
    public void givenBook_whenSave_thenGetOk() {
        //Given
        Books book = new Books(1l, "no", "no", LocalDate.now());
        bookRepository.save(book);
        //When
        List<Books> booksList = bookRepository.findAll();
        //Then
        assertEquals(1, booksList.size());
    }

    @Test
    public void givenCopy_whenSave_thenGetOk() {
        //Given
        Books book = new Books(1l, "no", "no", LocalDate.now());
        Copy copy = new Copy(1L, "Ordered", book);
        copyRepository.save(copy);
        //When
        List<Copy> copyList = copyRepository.findAll();
        //Then
        assertEquals(1, copyList.size());
    }

    @Test
    public void givenUser_whenSave_thenGetOk() {
        //Given
        Users users = new Users(1L, "Jack", "Jack", LocalDate.now());
        usersRepository.save(users);
        //When
        List<Users> usersList = usersRepository.findAll();
        //Then
        assertEquals(1, usersList.size());
    }

    @Test
    public void givenOrder_whenSave_thenGetOk() {
        //Given
        Books book = new Books(1l, "no", "no", LocalDate.now());
        Copy copy = new Copy(1L, "Ordered", book);
        Users users = new Users(1L, "Jack", "Jack", LocalDate.now());
        Order order = new Order(1L, "status", users, copy);
        orderRepository.save(order);
        //When
        List<Order> ordersList = orderRepository.findAll();
        //Then
        assertEquals(1, ordersList.size());
    }

    @Test
    public void givenStatus_whenSave_thenGetOk() {
        //Given
        Books book = new Books(1l, "no", "no", LocalDate.now());
        Copy copy = new Copy(1L, "available", book);
        bookRepository.save(book);
        copyRepository.save(copy);
        //When
        List<BookAvailable> bookAvailables = bookStatusRepository.countAvailableCopies();
        //Then
        assertEquals(1, bookAvailables.size());
    }


}
