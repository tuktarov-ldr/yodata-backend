package ru.lanit.bpm.yodata.app.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.lanit.bpm.yodata.app.api.DuplicateEntityException;
import ru.lanit.bpm.yodata.app.api.UserService;
import ru.lanit.bpm.yodata.app.repo.UserRepository;
import ru.lanit.bpm.yodata.domain.User;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public void registerUser(String login, String password, String firstName, String lastName, Long telegramId) throws DuplicateEntityException{

        if (userRepository.findById(login).isPresent()) {
            throw new DuplicateEntityException("User already exists");
        } else {
        userRepository.save(new User(login, password, firstName, lastName, telegramId));
        }
    }

    @Override
    public void updatePass(String login, String password) {
//        userRepository.save(userRepository.findById(login))
    }

    @Override
    public Optional<User> getUserByTelegramId(Long telegramId) {
        return userRepository.findByTelegramId(telegramId);
    }
}
