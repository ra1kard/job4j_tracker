package ru.job4j.tracker;

/**
 * Каркас шаблона синглтон Singleton
 * 1. private static Singleton instance = null - ссылка на единственный объект класса Singleton
 * 2. private Singleton() - явно создаем закрытый конструктор.
 * 3. public static Singleton getInstance() - статический метод. Он используется для публикации ссылки.
 */
public class Singleton {
    private static Singleton instance = null;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

}
