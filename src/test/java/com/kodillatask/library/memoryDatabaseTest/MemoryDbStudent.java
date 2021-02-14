package com.kodillatask.library.memoryDatabaseTest;


import com.kodillatask.library.domian.Users;
import com.kodillatask.library.repository.*;
import com.kodillatask.library.service.UsersService;
import org.apache.catalina.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = { UserJpaConfig.class },
        loader = AnnotationConfigContextLoader.class)

@SpringBootTest
public class MemoryDbStudent
{
   @Autowired
   private UsersRepository usersRepository;


    @Test
    public  void saveTest() throws Exception {
    //   Users user=new Users(1L,"no","no", LocalDate.now());
      // Users saved =  usersRepository.save(user);
      // List<Users> usersList=usersRepository.findAll();

     //  assertEquals(1,usersList.size());

    }
}

