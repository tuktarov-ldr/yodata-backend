package ru.lanit.bpm.yodata.adapter.telegram;

public interface TelegramAdapter {
    void notifyUser(Long telegramId, String message);
}
