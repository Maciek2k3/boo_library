package com.kodillatask.library.mapper;

import com.kodillatask.library.domian.Books;
import com.kodillatask.library.domian.BooksDto;
import com.kodillatask.library.domian.Copy;
import com.kodillatask.library.domian.CopyDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CopyMapper {
    public Copy mapToCopy (final CopyDto copy){
        return new Copy(copy.getId(), copy.getStatus(), new Books(copy.getBookId()));
    }

    public CopyDto maptoCopyDto (final Copy copy){
        return new CopyDto(copy.getId(), copy.getStatus(), copy.getBooks().getId());
    }

    public List<CopyDto> mapToCopyList(final List<Copy> copyList){
        return copyList.stream().map(this::maptoCopyDto).collect(Collectors.toList());
    }
}
