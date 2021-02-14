package com.kodillatask.library.domian;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "getOrders")
public class Order {
    @Id
    //@GeneratedValue
    private Long id;

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "User_id")
    //private Users users;

    @Column(name = "status")
    private String Status;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id")
    private Users users;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "copy_id")
    private Copy copy;

    // @OneToMany(mappedBy = "Order", cascade = CascadeType.ALL, orphanRemoval = true)
    // private List<Copy> copyList = new ArrayList<>();


}
