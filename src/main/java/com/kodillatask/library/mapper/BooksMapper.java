package com.kodillatask.library.mapper;

import com.kodillatask.library.domian.Books;
import com.kodillatask.library.domian.BooksDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BooksMapper {
    public Books mapToBooks (final BooksDto book){
        return new Books(book.getId(), book.getTitle(), book.getAuthor(), book.getProductionDate());
    }

    public BooksDto maptoBookDto (final Books book){
        return new BooksDto(book.getId(), book.getTitle(), book.getAuthor(), book.getProductionDate());
    }

    public List<BooksDto> mapToCasseteList(final List<Books> booksList){
        return booksList.stream().map(this::maptoBookDto).collect(Collectors.toList());
    }
}

