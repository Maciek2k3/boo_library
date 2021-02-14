package com.kodillatask.library.memoryDatabaseTest;

import com.kodillatask.library.domian.Users;
import com.kodillatask.library.repository.UsersRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MemoryTest.class)
public class MemoryTest {

    @Autowired
    UsersRepository personRepository;

    @Test
    public void should_get_h2_db_records() {
        Users personActual = personRepository
                .save(new Users(1L,"no","no", LocalDate.now()));
        Optional<Users> expected=personRepository
                .findById(personActual.getId());
        Assert
                .assertEquals(personActual.getId(),expected.get().getId());
    }
}

