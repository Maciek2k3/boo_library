package com.kodillatask.library.domian;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Copy")
public class Copy{
    @Id
    private Long Id;

    @Column(name = "status")
    private String Status;
   // @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "order_id")
    //private Order order;
   @ManyToOne(fetch = FetchType.EAGER, optional = false)
   @JoinColumn(name = "book_id")
   private Books books;

    public Copy(Long copyId) {
        Id = copyId;
    }
}


