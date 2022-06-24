package ru.job4j.tracker;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    /**
     * добавление заявок:
     * */
    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    /**
     * получение списка всех заявок:
     * возвращает копию массива items без null элементов (без пустых ячеек).
     * */
    public Item[] findAll() {
        Item[] rsl = new Item[items.length];
        for (int i = 0; i < rsl.length; i++) {
            System.out.println(rsl[i]);
        }
        return rsl;
    }

    /**
     * получение списка по имени
     * ---
     * проверяет в цикле все элементы массива items, сравнивая name
     * (используя метод getName класса Item) с аргументом метода String key.
     * Элементы, у которых совпадает name, копирует в результирующий массив и
     * возвращает его. Алгоритм этого метода аналогичен методу findAll.
     * */
    /*public Item[] findByName(String key) {

    }*/

    /**
     * получение заявки по id
     * ---
     * проверяет в цикле все элементы массива items, сравнивая id с аргументом int id
     * и возвращает найденный Item. Если Item не найден - возвращает null.
     * */
    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        Item result = tracker.findAll()[0];
    }

}
