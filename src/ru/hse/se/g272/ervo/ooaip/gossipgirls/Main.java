package ru.hse.se.g272.ervo.ooaip.gossipgirls;

import java.util.Scanner;

/**
 * @author Ervo Victor, 272SE
 * @since 11.16.2013
 */
public class Main {
    /**
     * Все сплетницы
     */
    private static GirlMap allGirls = new GirlMap();

    /**
     * Сканер пользовательского ввода
     */
    private static Scanner jin = new Scanner(System.in);

    public static void main(String[] args) {
        boolean timeToExit = false;
        do {
            System.out.println("Выберите действие: ");
            System.out.println("1. Create");
            System.out.println("2. Link");
            System.out.println("3. Unlink");
            System.out.println("4. Message");
            System.out.println("5. Print");
            System.out.println("6. Exit");
            try {
                int choice = Integer.parseInt(jin.nextLine());
                switch (choice) {
                    case 1: {
                        create();
                        break;
                    }
                    case 2: {
                        link();
                        break;
                    }
                    case 3: {
                        unlink();
                        break;
                    }
                    case 4: {
                        message();
                        break;
                    }
                    case 5: {
                        print();
                        break;
                    }
                    case 6: {
                        timeToExit = true;
                        break;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод");
            }
        } while (!timeToExit);
    }

    /**
     * Вывод на экран информации обо всех сплетницах
     */
    private static void print() {
        for (GossipGirl girl : allGirls) {
            System.out.println(girl);
        }
    }

    /**
     * Метод, посылающий сообщение одной из сплетниц
     */
    private static void message() {
        if (allGirls.size() < 1) {
            System.out.println("Недостаточно сплетниц для посылки сообщения");
            return;
        }
        System.out.println("Введите сообщение, которое Вы хотите послать");
        String message = jin.nextLine();
        NamesGetter namesGetter = new NamesGetter().invoke(NamesGetter.Action.MESSAGE);
        String name = namesGetter.getName();
        allGirls.byName(name).receiveMessage(message);
    }

    /**
     * Метод, разрывающий связь между двумя сплетницами
     */
    private static void unlink() {
        if (allGirls.size() < 2) {
            System.out.println("Недостаточно сплетниц для разрыва связи");
            return;
        }
        NamesGetter namesGetter = new NamesGetter().invoke(NamesGetter.Action.UNLINK);
        String name = namesGetter.getName();
        String subscriberName = namesGetter.getSubscriberName();
        allGirls.byName(name).unlink(allGirls.byName(subscriberName));
    }

    /**
     * Метод, создающий связь между двумя сплетницами
     */
    private static void link() {
        if (allGirls.size() < 2) {
            System.out.println("Недостаточно сплетниц для создания связи");
            return;
        }
        NamesGetter namesGetter = new NamesGetter().invoke(NamesGetter.Action.LINK);
        String name = namesGetter.getName();
        String subscriberName = namesGetter.getSubscriberName();
        allGirls.byName(name).link(allGirls.byName(subscriberName));
    }

    /**
     * Метод, создающий новую сплетницу
     */
    private static void create() {
        System.out.println("Введите имя новой сплетницы");
        String name = jin.nextLine();
        boolean nameWasGood = !name.contains("|"); // | используется как разделитель
        name = name.replace('|', '_');
        boolean nameIsGood = !allGirls.contains(name);
        nameWasGood &= nameIsGood;
        while (!nameIsGood) {
            name += "_";
            nameIsGood = !allGirls.contains(name);
        }
        if (!nameWasGood) {
            //строка выглядит так для корректной генерации JavaDoc файлов
            System.out.println("\u0418\u043c\u044f \u0431\u044b\u043b\u043e \u0438\u0437\u043c\u0435\u043d\u0435\u043d\u043e \u043d\u0430 " + name);
        }
        allGirls.put(new GossipGirl(name));
    }

    /**
     * Класс, получающий от пользователя существующие имена сплетниц
     */
    private static class NamesGetter {
        /**
         * Действия, которые могут потребовать определения имени сплетнецы
         */
        enum Action {
            LINK, MESSAGE, UNLINK
        }

        //комментарий выглядит так для корректной генерации JavaDoc файлов
        /**
         * &#x418;&#x43c;&#x44f; &#x441;&#x43f;&#x43b;&#x435;&#x442;&#x43d;&#x435;&#x446;&#x44b;
         */
        private String name;

        //комментарий выглядит так для корректной генерации JavaDoc файлов
        /**
         * &#x418;&#x43c;&#x44f; &#x43f;&#x43e;&#x434;&#x43f;&#x438;&#x441;&#x447;&#x438;&#x446;&#x44b;
         */
        private String subscriberName;

        //комментарий выглядит так для корректной генерации JavaDoc файлов
        /**
         * &#x41f;&#x43e;&#x43b;&#x443;&#x447;&#x430;&#x435;&#x442; &#x438;&#x43c;&#x44f; &#x441;&#x43f;&#x43b;&#x435;&#x442;&#x43d;&#x438;&#x446;&#x44b;
         * @return &#x418;&#x43c;&#x44f; &#x441;&#x43f;&#x43b;&#x435;&#x442;&#x43d;&#x438;&#x446;&#x44b;
         */
        public String getName() {
            return name;
        }

        //комментарий выглядит так для корректной генерации JavaDoc файлов
        /**
         * &#x41f;&#x43e;&#x43b;&#x443;&#x447;&#x430;&#x435;&#x442; &#x438;&#x43c;&#x44f; &#x43f;&#x43e;&#x434;&#x43f;&#x438;&#x441;&#x447;&#x438;&#x446;&#x44b;
         * @return &#x418;&#x43c;&#x44f; &#x43f;&#x43e;&#x434;&#x43f;&#x438;&#x441;&#x447;&#x438;&#x446;&#x44b;
         */
        public String getSubscriberName() {
            return subscriberName;
        }

        /**
         * Определяет необходимые имена
         * @param action Действие, требующее определение имян
         * @return Объект, содержащий необходимые имена
         */
        public NamesGetter invoke(Action action) {
            String actionText = null;
            switch (action) {
                case LINK:
                    actionText = "которой надо добавить подписчицу";
                    break;
                case UNLINK:
                    actionText = "у которой надо удалить подписчицу";
                    break;
                case MESSAGE:
                    actionText = "которой надо послать сообщение";
                    break;
            }
            //строка выглядит так для корректной генерации JavaDoc файлов
            System.out.println("\u0418\u043c\u0435\u043d\u0430 \u0441\u043f\u043b\u0435\u0442\u043d\u0438\u0446: ");
            System.out.print("|");
            for (GossipGirl girl: allGirls) {
                System.out.print(girl.getName() + "|");
            }
            System.out.println();
            do {
                System.out.println("Введите имя сплетницы, " + actionText);
                name = jin.nextLine();
                if (!allGirls.contains(name)) {
                    System.out.println("Нет сплетницы с таким именем");
                }
            } while (!allGirls.contains(name));
            if (action != Action.MESSAGE) {
                do {
                    System.out.println("Введите имя подписчицы");
                    subscriberName = jin.nextLine();
                    if (!allGirls.contains(subscriberName)) {
                        System.out.println("Нет сплетницы с таким именем");
                    } else if (name.equals(subscriberName)) {
                        System.out.println("Не стоит подписывать сплетницу на саму себя");
                    }
                } while (!allGirls.contains(subscriberName) || name.equals(subscriberName));
            }
            return this;
        }
    }
}