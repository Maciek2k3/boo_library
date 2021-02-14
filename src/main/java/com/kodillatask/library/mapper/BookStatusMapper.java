package com.kodillatask.library.mapper;

import com.kodillatask.library.domian.BookStatus;
import com.kodillatask.library.domian.BookStatusDto;
import com.kodillatask.library.domian.Books;
import org.hibernate.Session;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookStatusMapper {
    public BookStatus mapToBooksStatus (final BookStatusDto bookStatus){
        return new BookStatus(bookStatus.getId(), new Books(bookStatus.getBookTitle()),bookStatus.getCopyAvaiable());
    }

    public BookStatusDto maptoBookStatusDto (final BookStatus bookStatus){
        return new BookStatusDto(bookStatus.getId(),bookStatus.getBooks().getTitle(),bookStatus.getCopyAvaiable());
    }

    public List<BookStatusDto> mapToBookStatusList(final List<BookStatus> booksList){
        return booksList.stream().map(this::maptoBookStatusDto).collect(Collectors.toList());
    }

}

