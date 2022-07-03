package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    /**
     * инициализирует приложение и запускает выполнение различных пользовательских действий;
     */
    public void init(Scanner scanner, Tracker tracker) {

    }

    /**
     * выводит на экран меню доступных пользовательских действий;
     */
    private void showMenu() {

    }

    /**
     * Scanner позволит получать данные с консоли от пользователя, Tracker будет служить хранилищем заявок.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }

}
