package com.kodillatask.library.repository;

import com.kodillatask.library.domian.BookStatus;
import com.kodillatask.library.domian.Books;
import com.kodillatask.library.domian.Copy;
import com.kodillatask.library.domian.CopyDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CopyRepository extends CrudRepository<Copy, Long> {
    List<Copy> findAll();

    Optional<Copy> findById(Long id);

    @Query(value = "select count(*) from copy\n" +
                    "join books on copy.book_id = books.id\n" +
                    "where title = ?1 and copy.status = 'available';",
            nativeQuery = true)
    Integer countAvailableCopies(String title);

    @Query(value = "select books.id, books.title, count(copy.book_id) as copy_available from books\n" +
            "join copy on copy.book_id = books.id\n" +
            "where copy.status = 'available'\n" +
            "group by copy.book_id;",
            nativeQuery = true)
    List<Copy> countAvailableCopies();
}

