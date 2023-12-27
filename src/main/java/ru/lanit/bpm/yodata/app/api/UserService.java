package ru.lanit.bpm.yodata.app.api;

import ru.lanit.bpm.yodata.domain.User;

import java.util.Optional;

public interface UserService {
    void registerUser(String login, String password, String firstName, String lastName, Long telegramId) throws DuplicateEntityException;

    void updatePass (String login, String password);
    Optional<User> getUserByTelegramId(Long telegramId);
}
