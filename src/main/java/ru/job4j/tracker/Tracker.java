package ru.job4j.tracker;

import java.util.Arrays;

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
        Item[] rsl = new Item[size];
        int count = 0;
        for (int i = 0; i < items.length; i++) {
            Item valueItem = items[i];
            if (valueItem != null) {
                rsl[count] = valueItem;
                count++;
            }
        }
        rsl = Arrays.copyOf(rsl, size);
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
    public Item[] findByName(String key) {
        Item[] rsl = new Item[size];
        int count = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getName().equals(key)) {
                rsl[count] = items[i];
                count++;
            }
        }
        rsl = Arrays.copyOf(rsl, count);
        return rsl;
    }

    /**
     * получение заявки по id
     * ---
     * проверяет в цикле все элементы массива items, сравнивая id с аргументом int id
     * и возвращает найденный Item. Если Item не найден - возвращает null.
     * ---
     * Находим индекс
     * /* Если индекс найден возвращаем item, иначе null
     */
    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        boolean rsl = false;
        int value = indexOf(id);
        if (value != -1) {
            items[value].setName(item.getName());
            rsl = true;
        }
        return rsl;
    }

    public boolean delete(int id) {
        int start = indexOf(id) + 1;
        int distPos = indexOf(id);
        int length = size - indexOf(id) - 1;
        System.arraycopy(items, start, items, distPos, length);
        items[size - 1] = null;
        size--;
        return true;
    }

}
