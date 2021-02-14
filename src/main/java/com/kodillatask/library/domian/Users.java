package com.kodillatask.library.domian;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="users")
public class Users {
    @Id
    @GeneratedValue
    private Long Id;
    @Column(name = "username")
    private String userName;
    @Column(name = "usersurname")
    private String userSurname;
    @Column(name = "accountdate")
    private LocalDate accountDate;

    public Users(Long userId) {
        Id = userId;
    }
}
   // @OneToMany(mappedBy = "users", cascade = CascadeType.ALL, orphanRemoval = true)
    //private List<Order> orderList = new ArrayList<>();

