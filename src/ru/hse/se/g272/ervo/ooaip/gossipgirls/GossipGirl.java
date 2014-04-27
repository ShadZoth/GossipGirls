package ru.hse.se.g272.ervo.ooaip.gossipgirls;

import java.util.HashSet;

/**
 * Сплетница.
 *
 * Связь между сплетницами является односторонней
 *
 * @author Ervo Victor, 272SE
 * @since 16.11.13
 */
public class GossipGirl implements MessageReceiver {

    //комментарий выглядит так для корректной генерации JavaDoc файлов
    /**
     * &#x418;&#x43c;&#x44f; &#x441;&#x43f;&#x43b;&#x435;&#x442;&#x43d;&#x438;&#x446;&#x430;
     */
    private final String name;

    /**
     * Подписчицы сплетницы
     */
    private HashSet<GossipGirl> subscribers;

    //комментарий выглядит так для корректной генерации JavaDoc файлов
    /**
     * &#x421;&#x43e;&#x437;&#x434;&#x430;&#x451;&#x442; &#x441;&#x43f;&#x43b;&#x435;&#x442;&#x43d;&#x438;&#x446;&#x443; &#x441; &#x437;&#x430;&#x434;&#x430;&#x43d;&#x43d;&#x44b;&#x43c; &#x438;&#x43c;&#x435;&#x43d;&#x435;&#x43c;
     * @param name &#x418;&#x43c;&#x44f; &#x441;&#x43f;&#x43b;&#x435;&#x442;&#x43d;&#x438;&#x446;&#x44b;
     */
    public GossipGirl(String name) {
        this.name = name;
        subscribers = new HashSet<GossipGirl>();
    }

    /**
     * Добавляет подписчицу
     * @param girl Подписчица
     */
    public void link(GossipGirl girl) {
        subscribers.add(girl);
    }

    /**
     * Удаляет подписчицу
     * @param girl Подписчица
     */
    public void unlink(GossipGirl girl) {
        subscribers.remove(girl);
    }

    /**
     * Метод получения объектом сообщения
     *
     * @param message Сообщение
     */
    @Override
    public void receiveMessage(String message) {
        receiveSpecialMessage(new Message(message));
    }

    /**
     * Метод получения особого сообщения и передачи его подписчицам, избегающий циклических ссылок
     * @param message Особое сообщение
     */
    private void receiveSpecialMessage(Message message) {
        System.out.println(getName() + " приняла сообщение \"" + message.getText() + "\"");
        message.addReceiver(this);
        for (GossipGirl girl: subscribers) {
            if (!message.wasReceivedBy(girl)) {
                girl.receiveSpecialMessage(message);
            }
        }
    }

    /**
     * Получает имя сплетницы
     * @return имя сплетницы
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        String result = "Сплетница ";
        result += getName();
        result += ". Подписчицы: |";
        for (GossipGirl girl: subscribers) {
            result+= girl.getName();
            result += "|";
        }
        return result;
    }
}