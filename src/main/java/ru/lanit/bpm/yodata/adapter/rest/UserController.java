package ru.lanit.bpm.yodata.adapter.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.lanit.bpm.yodata.app.api.DuplicateEntityException;
import ru.lanit.bpm.yodata.app.api.UserService;
import ru.lanit.bpm.yodata.domain.User;

@RequiredArgsConstructor
@RestController
@RequestMapping("/yodata/admin/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user) {
        try {
            userService.registerUser(user.getLogin(), user.getPassword(), user.getFirstName(), user.getLastName(), user.getTelegramId());
            return ResponseEntity.ok("Created");
        } catch (DuplicateEntityException e) {
            return ResponseEntity.badRequest().body((e.getMessage()));
        }
    }
}
