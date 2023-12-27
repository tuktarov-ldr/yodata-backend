package ru.lanit.bpm.yodata.adapter.telegram.handlers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.lanit.bpm.yodata.app.api.DuplicateEntityException;
import ru.lanit.bpm.yodata.app.api.UserService;
import ru.lanit.bpm.yodata.domain.User;

import java.util.Optional;

@RequiredArgsConstructor
@Component("createUserTelegramCommandHandler")
public class CreateUserCommandHandler implements CommandHandler {

    private final UserService userService;
    @Override
    public void handleMessage(Update update, Optional<User> user, SendMessage response) {
        try {
            userService.registerUser(update.getMessage().getText(), "",
                    update.getMessage().getFrom().getFirstName(),
                    update.getMessage().getFrom().getLastName(),
                    update.getMessage().getFrom().getId());
            response.setText("Теперь введите пароль: ");
        } catch (DuplicateEntityException e) {
            response.setText("Пользователь уже существует");
        }
    }
}
