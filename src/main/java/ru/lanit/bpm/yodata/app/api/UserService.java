package ru.lanit.bpm.yodata.app.api;

public interface UserService {
    void registerUser(String login, String password, String firstName, String lastName, Long telegramId) throws DuplicateEntityException;
}
