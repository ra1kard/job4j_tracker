package ru.job4j.tracker;

/**
 * Этим интерфейсом можно описать все действия системы
 */
public interface UserAction {

    String name();

    boolean execute(Input input, Tracker tracker);

}
