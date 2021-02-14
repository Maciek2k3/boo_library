package com.kodillatask.library.repository;

import com.kodillatask.library.domian.Books;
import com.kodillatask.library.domian.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<Books,Long> {
    List<Books> findAll();

    Optional<Books> findById(Long id);
}
