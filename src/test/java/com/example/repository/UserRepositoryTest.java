package com.example.repository;

import com.example.model.User;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringRunner.class)
@DataJpaTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void findByEmail_NotOk() {
        User leo = new User();
        leo.setName("Leo");
        leo.setEmail("leo@mail.com");
        userRepository.save(leo);

        Optional<User> bobOptional = userRepository.findByEmail("bob@mail.com");
        assertThrows(NoSuchElementException.class, bobOptional::get);
        Optional<User> mikeOptional = userRepository.findByEmail("mike@mail.com");
        assertThrows(NoSuchElementException.class, mikeOptional::get);
    }

    @Test
    public void findByEmail_Ok() {
        User alex = new User();
        alex.setName("Alex");
        alex.setEmail("alex@mail.com");
        userRepository.save(alex);

        Optional<User> alexOptional = userRepository.findByEmail("alex@mail.com");
        assertEquals("alex@mail.com", alexOptional.get().getEmail());
        assertEquals("Alex", alexOptional.get().getName());

        User john = new User();
        john.setName("John");
        john.setEmail("john@mail.com");
        userRepository.save(john);

        Optional<User> johnOptional = userRepository.findByEmail("john@mail.com");
        assertEquals("john@mail.com", johnOptional.get().getEmail());
        assertEquals("John", johnOptional.get().getName());
    }
}
