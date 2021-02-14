package com.kodillatask.library.domian;


import com.kodillatask.library.repository.BookStatusRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "bookStatus")
@SqlResultSetMapping(name = "countAvailableCopies",
        classes = @ConstructorResult(
                targetClass = com.kodillatask.library.repository.BookStatusRepository.class,
                columns = {
                        @ColumnResult(name = "id", type = Long.class),
                        @ColumnResult(name = "title", type = String.class),
                        @ColumnResult(name = "copyAvailable", type = Integer.class)
                }
        )
)
public class BookStatus {
    @Id
    private int id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "title")
    private Books books;

    @Column(name = "copyAvailable")
    private int copyAvaiable;

    public BookStatus(Books books) {
        this.books = books;
    }
}
