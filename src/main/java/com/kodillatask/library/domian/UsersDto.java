package com.kodillatask.library.domian;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
public class UsersDto {
    private Long id;
    private String userName;
    private String userSurname;
    private LocalDate accountDate;
    //private List<Order> orderList;
}
