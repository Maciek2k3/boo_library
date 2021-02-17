package com.kodillatask.library.domian;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="books")
public class Books {
    @Id
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "productionDate")
    private LocalDate productionDate;
    //@OneToMany(mappedBy = "books", cascade = CascadeType.ALL, orphanRemoval = true)
   // private List<Copy> copyList = new ArrayList<>();


    public Books(Long bookId) {
        this.id = bookId;
    }

    public Books(String title) {
        this.title = title;
    }

}

