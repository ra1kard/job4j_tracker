package ru.job4j.oop;

/**
 * Сказка колобок:
 *      Ball    колобок
 *      Hare    заяц
 *      Wolf    волк
 *      Fox     лиса
 *      BallStory
 * В классе Ball должен быть определен метод public void tryRun(boolean condition).
 * Если метод вызван с аргументом true, то метод должен вывести строку с сообщением о том,
 * что колобок съеден, иначе - сообщение о том, что колобок сбежал.
 */
public class Ball {

    public void tryRun(boolean condition) {
        if (condition) {
            System.out.println("Колобок съеден");
        } else {
            System.out.println("Колобок сбежал");
        }
    }

}
