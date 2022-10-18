package ru.job4j.tracker;

/**
 * Каркас шаблона синглтон Singleton
 * 0. class final (нужно запретить наследование этого класса. Для этого используем ключевое слово final)
 * 1. private static Singleton instance = null - ссылка на единственный объект класса Singleton
 * 2. private Singleton() - явно создаем закрытый конструктор, т.е.:
 * Создать явно конструктор и указать у него модификатор private.
 * Таким образом, никто не сможет создать объект этого класса.
 * 3. public static Singleton getInstance() - статический метод. Он используется для публикации ссылки.
 */
public final class Singleton {
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
