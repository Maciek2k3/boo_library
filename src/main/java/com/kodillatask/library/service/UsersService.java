package com.kodillatask.library.service;

import com.kodillatask.library.domian.Users;
import com.kodillatask.library.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
public class UsersService {

    public final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<Users> findAllUsers() {
        return usersRepository.findAll();

    }

    public void deleteUserById(Long id) {
        usersRepository.deleteById(id);
    }

    public Optional<Users> findUserById(Long id) {
        return usersRepository.findById(id);
    }

    public Users saveUser(final Users users) {
        return usersRepository.save(users);
    }
}
