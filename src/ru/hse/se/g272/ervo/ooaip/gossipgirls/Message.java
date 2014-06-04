package ru.hse.se.g272.ervo.ooaip.gossipgirls;

import java.util.HashSet;
import java.util.Set;

/**
 * Сообщение, которое может передаваться
 *
 * @author Ervo Victor, 272SE
 * @since 16.11.2013
 */
public class Message {
    /**
     * Текст сообщения
     */
    private final String text;

    /**
     * Получатели, которым сообщение уже доставлено
     */
    private final Set<MessageReceiver> alreadyReceived;

    /**
     * Создаёт сообщение с заданным текстом
     * @param text Текст сообщения
     */
    public Message(String text) {
        this.text = text;

        alreadyReceived = new HashSet<>();
    }

    /**
     * Получает текст сообщения
     * @return текст сообщения
     */
    public String getText() {
        return text;
    }

    /**
     * Отметить, что {@code receiver} получил данное сообщение
     * @param receiver Получатель
     */
    public void addReceiver(MessageReceiver receiver) {
        alreadyReceived.add(receiver);
    }

    /**
     * Проверяет, получил ли {@code receiver} данное сообщение
     * @param receiver Получатель
     * @return {@code true}, если получил; {@code false} - иначе
     */
    public boolean wasReceivedBy(MessageReceiver receiver) {
        return alreadyReceived.contains(receiver);
    }
}