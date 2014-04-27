package ru.hse.se.g272.ervo.ooaip.gossipgirls;

//комментарий выглядит так для корректной генерации JavaDoc файлов
/**
 * &#x418;&#x43d;&#x442;&#x435;&#x440;&#x444;&#x435;&#x439;&#x441; &#x434;&#x43b;&#x44f; &#x43e;&#x431;&#x44a;&#x435;&#x43a;&#x442;&#x43e;&#x432;, &#x441;&#x43f;&#x43e;&#x441;&#x43e;&#x431;&#x43d;&#x44b;&#x445; &#x43f;&#x440;&#x438;&#x43d;&#x438;&#x43c;&#x430;&#x442;&#x44c; &#x441;&#x43e;&#x43e;&#x431;&#x449;&#x435;&#x43d;&#x438;&#x44f;
 *
 * @author Ervo Victor, 272SE
 * @since 16.11.13
 */
public interface MessageReceiver {
    /**
     * Метод получения объектом сообщения
     * @param message Сообщение
     */
    public void receiveMessage(String message);
}

