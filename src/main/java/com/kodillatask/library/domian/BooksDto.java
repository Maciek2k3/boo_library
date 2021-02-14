package com.kodillatask.library.domian;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
public class BooksDto {
    private Long id;
    private String title;
    private String author;
    private LocalDate productionDate;


}
