package com.kodillatask.library.controller;

import com.kodillatask.library.domian.Books;
import com.kodillatask.library.domian.BooksDto;
import com.kodillatask.library.mapper.BooksMapper;
import com.kodillatask.library.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("library/v1")
@CrossOrigin(origins = "*")
public class BooksController {


    private BooksMapper booksMapper;
    private BooksService booksService;

    @Autowired
    public BooksController(BooksMapper booksMapper, BooksService booksService) {
        this.booksMapper = booksMapper;
        this.booksService = booksService;
    }


    @GetMapping("/getBooks")
    public List<BooksDto> getAllBooks() {
        List<Books> books = booksService.findAllBooks();
        return booksMapper.mapToCasseteList(books);
    }

    @GetMapping("/getBook")
    @ResponseBody
    public BooksDto getByIdBook(@RequestParam long id) throws NotFoundEeption {
        return booksMapper.maptoBookDto(booksService.findBookById(id).
                orElseThrow(NotFoundEeption::new));
    }


    @DeleteMapping("/deleteBook")
    public void deleteByIdBook(@RequestParam long id) {
        booksService.deleteBookById(id);
    }

    @PutMapping("/updateBook")
    public BooksDto udpateBook(@RequestBody BooksDto booksDto) {
        Books book = booksMapper.mapToBooks(booksDto);
        Books savedBook = booksService.saveBook(book);
        return booksMapper.maptoBookDto(savedBook);
    }

    @PostMapping("/addBook")
    public void addBook(@RequestBody BooksDto booksDto) {
        Books books = booksMapper.mapToBooks(booksDto);
        booksService.saveBook(books);
    }
}
