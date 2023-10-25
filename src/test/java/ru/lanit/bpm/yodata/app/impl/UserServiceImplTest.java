package ru.lanit.bpm.yodata.app.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.lanit.bpm.yodata.app.api.DuplicateEntityException;
import ru.lanit.bpm.yodata.app.api.UserService;
import ru.lanit.bpm.yodata.app.repo.UserRepository;
import ru.lanit.bpm.yodata.domain.User;
import ru.lanit.bpm.yodata.fw.YodataBackendApplication;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = YodataBackendApplication.class)
class UserServiceImplTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Transactional
    @Test
    void registerUser_success() throws DuplicateEntityException {
        userService.registerUser("a", "b", "c", "d", 1L);

        User user = userRepository.findById("a").orElseThrow();
        assertEquals("b", user.getPassword());
        assertEquals("c", user.getFirstName());
        assertEquals("d", user.getLastName());
        assertEquals(1L, user.getTelegramId());
    }

    @Transactional
    @Test
    void registerUser_duplicate() {
        assertThrows(DuplicateEntityException.class, () -> {
            userService.registerUser("a", "b", "c", "d", 1L);
            userService.registerUser("a", "b", "c", "d", 1L);
        });

    }

}