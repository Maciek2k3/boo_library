package com.kodillatask.library.controller;

import com.kodillatask.library.domian.*;
import com.kodillatask.library.mapper.BookStatusMapper;
import com.kodillatask.library.repository.BookStatusRepository;
import com.kodillatask.library.service.BookStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("library/v1")
@CrossOrigin(origins = "*")
public class BookStatusController {

    private BookStatusService bookStatusService;
    private BookStatusMapper bookStatusMapper;

    @Autowired
    public BookStatusController(BookStatusService bookStatusService, BookStatusMapper bookStatusMapper) {
        this.bookStatusService = bookStatusService;
        this.bookStatusMapper = bookStatusMapper;
    }

    @GetMapping("/getStatus")
    public List<BookAvailable> getAllBookStaus() {
        //List<BookStatus> bookStatuses=
        return bookStatusService.findAllBookStatud();
        //return bookStatusMapper.mapToBookStatusList(bookStatuses);
    }

}
