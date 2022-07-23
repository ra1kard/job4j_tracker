package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    /**
     * инициализирует приложение и запускает выполнение различных пользовательских действий;
     */
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            System.out.print("Select: ");
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ===");
                System.out.println("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
                System.out.println("Добавленная заявка: " + item);
            } else if (select == 6) {
                run = false;
            }
        }
    }

    /**
     * выводит на экран меню доступных пользовательских действий;
     * 0. Add new Item          1. Добавление заявки;       add
     * 1. Show all items        2. Вывод всех заявок;       findAll
     * 2. Edit item             3. Изменение заявки;        replace
     * 3. Delete item           4. Удаление заявки;         delete
     * 4. Find item by id       5. Вывод заявки по id;      findById
     * 5. Find items by name    6. Вывод заявок по имени.   findByName
     * 6. Exit Program
     */
    private void showMenu() {
        String[] menu = {
                "Add new Item", "Show all items", "Edit item",
                "Delete item", "Find item by id", "Find items by name",
                "Exit Program"
        };
        System.out.println("Menu:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
    }

    /**
     * Scanner позволит получать данные с консоли от пользователя, Tracker будет служить хранилищем заявок.
     * просто запускает наше приложение
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }

}
