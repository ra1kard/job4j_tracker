package ru.job4j.tracker;

/**
 * предположим, что интерфейс будет опред.работу класса по получению данных от пользователя в консоли.
 * askStr - метод, который возвращает введенную строку от пользователя.
 * askInt - метод, который будет возвращать от пользователя число, а не строку.
 */
public interface Input {

    String askStr(String question);

    int askInt(String question);

}