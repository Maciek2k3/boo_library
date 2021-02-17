package com.kodillatask.library.dataProvider;

import com.kodillatask.library.domian.Books;
import com.kodillatask.library.domian.Copy;
import com.kodillatask.library.domian.Order;
import com.kodillatask.library.domian.Users;
import com.kodillatask.library.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Slf4j
public class InitData {

    private final UsersService usersService;
    private final BooksService booksService;
    private final CopyService copyService;
    private final OrderService orderService;
private final BookStatusService bookStatusService;

    @Autowired
    public InitData(UsersService usersService, BooksService booksService, CopyService copyService, OrderService orderService, BookStatusService bookStatusService) {
        this.usersService = usersService;
        this.booksService = booksService;
        this.copyService = copyService;
        this.orderService = orderService;
        this.bookStatusService = bookStatusService;
    }

    @EventListener(ContextRefreshedEvent.class)
    public void addToData(){
     // usersService.saveUser(new Users(1L,"Maciek","Maciek", LocalDate.now()));
     // usersService.saveUser(new Users(1L,"Maciek","Maciek", LocalDate.now()));
      //booksService.saveBook(new Books(3L,"Name","Name",LocalDate.now()));
       //booksService.saveBook(new Books(4L,"Name2","Name2",LocalDate.now()));
       //copyService.saveCopy(new Copy(1L,"available",new Books(3L)));
        //copyService.saveCopy(new Copy(2L,"noAvailable",new Books(4L)));
        //orderService.saveOrder(new Order(1L,"no",new Users(1L),new Copy(1L)));
        //orderService.saveOrder(new Order(2L,"no",new Users(1L),new Copy(2L)));
       // bookStatusService.findAllBookStatud();


    }
}
