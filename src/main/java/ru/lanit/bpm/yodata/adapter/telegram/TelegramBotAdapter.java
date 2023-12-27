package ru.lanit.bpm.yodata.adapter.telegram;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.lanit.bpm.yodata.adapter.telegram.handlers.CommandHandler;
import ru.lanit.bpm.yodata.app.api.UserService;
import ru.lanit.bpm.yodata.domain.User;

import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Component
@Slf4j
public class TelegramBotAdapter extends TelegramLongPollingBot implements TelegramAdapter {

    private static final String START_CMD = "/start";

    private final Map<String, CommandHandler> messageHandlers;
    @Value("${ru.lanit.bpm.yodata.bot.name}")
    private String botUserName;
    @Value("${ru.lanit.bpm.yodata.bot.token}")
    private String botToken;

    private final UserService userService;


    @Override
    public String getBotUsername() {
        return botUserName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        log.info("Message received: {}", update);
        if (update.hasMessage()) {
            SendMessage response = new SendMessage();
            response.setChatId(update.getMessage().getChatId().toString());
            String  messageText = update.getMessage().getText();
            Long userId = update.getMessage().getFrom().getId();
            Optional<User> user = userService.getUserByTelegramId(userId);
            if(START_CMD.equals(messageText)) {
                messageHandlers.get("startTelegramCommandHandler").handleMessage(update, user, response);
            } else if (user.isPresent()){
                messageHandlers.get("updatePasswordTelegramCommandHandler").handleMessage(update, user, response);
            } else {
                messageHandlers.get("createUserTelegramCommandHandler").handleMessage(update, user, response);
            }

            try {
                execute(response);
            } catch (TelegramApiException e) {
                log.error("Unable to send response", e);
            }
        }
    }

    @Override
    public void notifyUser(Long telegramId, String message) {
        SendMessage response = new SendMessage(telegramId.toString(), message);
        try {
            execute(response);
        } catch (TelegramApiException e) {
            log.error("unable to send message", e);
        }
    }
}
