package com.kodillatask.library.repository;

import com.kodillatask.library.domian.Users;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends CrudRepository<Users, Long> {
    @Override
    List<Users> findAll();

    @Override
    Users save(Users users);

    @Override
    Optional<Users> findById(Long id);
}
