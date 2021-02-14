package com.kodillatask.library.repository;

import com.kodillatask.library.domian.Books;
import com.kodillatask.library.domian.Copy;
import com.kodillatask.library.domian.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
    List<Order> findAll();

    Optional<Order> findById(Long id);

}
