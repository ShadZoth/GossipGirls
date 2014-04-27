package ru.hse.se.g272.ervo.ooaip.gossipgirls;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Коллекция сплетниц
 */
public class GirlMap implements Iterable<GossipGirl> {
    /**
     * Коллекция сплетниц
     */
    HashMap<String, GossipGirl> girlHashMap;

    /**
     * Создаёт пустую коллекцию сплетниц
     */
    public GirlMap() {
        girlHashMap = new HashMap<String, GossipGirl>();
    }

    //комментарий выглядит так для корректной генерации JavaDoc файлов
    /**
     * &#x41f;&#x440;&#x43e;&#x432;&#x435;&#x440;&#x44f;&#x435;&#x442;, &#x441;&#x43e;&#x434;&#x435;&#x440;&#x436;&#x438;&#x442; &#x43b;&#x438; &#x43a;&#x43e;&#x43b;&#x43b;&#x435;&#x43a;&#x446;&#x438;&#x44f; &#x441;&#x43f;&#x43b;&#x435;&#x442;&#x43d;&#x438;&#x446;&#x443;, &#x441; &#x443;&#x43a;&#x430;&#x437;&#x430;&#x43d;&#x43d;&#x44b;&#x43c; &#x438;&#x43c;&#x435;&#x43d;&#x435;&#x43c;
     * @param name &#x418;&#x43c;&#x44f; &#x441;&#x43f;&#x43b;&#x435;&#x442;&#x43d;&#x438;&#x446;&#x44b;
     * @return {@code true}, &#x435;&#x441;&#x43b;&#x438; &#x441;&#x43e;&#x434;&#x435;&#x440;&#x436;&#x438;&#x442;; {@code false} - &#x438;&#x43d;&#x430;&#x447;&#x435;
     */
    public boolean contains(String name) {
        return girlHashMap.containsKey(name);
    }

    /**
     * Проверяет, содержит ли коллекция указанную сплетницу
     * @param girl Сплетница
     * @return {@code true}, если содержит; {@code false} - иначе
     */
    public boolean contains(GossipGirl girl) {
        return girlHashMap.containsValue(girl);
    }

    /**
     * Добавляет сплетницу в коллекцию
     * @param girl Сплетница
     * @throws IllegalArgumentException если в коллекции уже есть сплетница с указанным именем
     */
    public void put(GossipGirl girl) throws IllegalArgumentException {
        if (contains(girl.getName())) {
            throw new IllegalArgumentException("Коллекция уже содержит девушку с таким именем");
        }
        girlHashMap.put(girl.getName(), girl);
    }

    /**
     * Определяет количество сплетниц в коллекции
     * @return Количество сплетниц в коллекции
     */
    public int size() {
        return girlHashMap.size();
    }

    //комментарий выглядит так для корректной генерации JavaDoc файлов
    /**
     * &#x41d;&#x430;&#x445;&#x43e;&#x434;&#x438;&#x442; &#x432; &#x43a;&#x43e;&#x43b;&#x43b;&#x435;&#x43a;&#x446;&#x438;&#x438; &#x441;&#x43f;&#x43b;&#x435;&#x442;&#x43d;&#x438;&#x446;&#x443; &#x441; &#x437;&#x430;&#x434;&#x430;&#x43d;&#x43d;&#x44b;&#x43c; &#x438;&#x43c;&#x435;&#x43d;&#x435;&#x43c;
     * @param name &#x418;&#x43c;&#x44f; &#x441;&#x43f;&#x43b;&#x435;&#x442;&#x43d;&#x438;&#x446;&#x44b;
     * @return &#x421;&#x43f;&#x43b;&#x435;&#x442;&#x43d;&#x438;&#x446;&#x430; &#x441; &#x437;&#x430;&#x434;&#x430;&#x43d;&#x43d;&#x44b;&#x43c; &#x438;&#x43c;&#x435;&#x43d;&#x435;&#x43c;
     * @throws IllegalArgumentException &#x435;&#x441;&#x43b;&#x438; &#x432; &#x43a;&#x43e;&#x43b;&#x43b;&#x435;&#x446;&#x438;&#x438; &#x43d;&#x435;&#x442; &#x441;&#x43f;&#x43b;&#x435;&#x442;&#x43d;&#x438;&#x446;&#x44b; &#x441; &#x437;&#x430;&#x434;&#x430;&#x43d;&#x43d;&#x44b;&#x43c; &#x438;&#x43c;&#x435;&#x43d;&#x435;&#x43c;
     */
    public GossipGirl byName(String name) throws IllegalArgumentException {
        if (!contains(name)) {
            throw new IllegalArgumentException("Нет сплетницы с таким именем");
        }
        return girlHashMap.get(name);
    }

    @Override
    public Iterator<GossipGirl> iterator() {
        return girlHashMap.values().iterator();
    }
}
