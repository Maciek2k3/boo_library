package com.kodillatask.library.domian;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class OrderDto {
    private Long id;
   // private Users users;
    private String Status;
    private Long UserId;
    //private List<Copy> copyList;
    private Long copyId;
}
