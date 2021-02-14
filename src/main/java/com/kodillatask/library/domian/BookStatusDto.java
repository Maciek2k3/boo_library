package com.kodillatask.library.domian;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Getter
@AllArgsConstructor
public class BookStatusDto {
    private int id;
    private String bookTitle;
    private int copyAvaiable;
}
