package ru.job4j.tracker;

public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ===");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Добавленная заявка: " + item);
    }

    public static void editItem(Input input, Tracker tracker) {
        System.out.println("=== Edit item ===");
        int id = Integer.parseInt(input.askStr("Enter id: "));
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Заявка изменена успешно.");
        } else {
            System.out.println("Ошибка замены заявки.");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete item ===");
        int id = Integer.parseInt(input.askStr("Enter id: "));
        if (tracker.delete(id)) {
            System.out.println("Заявка удалена успешно.");
        } else {
            System.out.println("Ошибка удаления заявки.");
        }
    }

    /**
     * инициализирует приложение и запускает выполнение различных пользовательских действий;
     */
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            int select = Integer.parseInt(input.askStr("Select: "));
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                System.out.println("=== Show all items ===");
                Item[] items = tracker.findAll();
                if (items.length > 0) {
                    for (Item item : items) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("Хранилище еще не содержит заявок");
                }
            } else if (select == 2) {
                StartUI.editItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                System.out.println("=== Find item by id ===");
                int id = Integer.parseInt(input.askStr("Enter id: "));
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(item);
                } else {
                    System.out.println("Заявка с введенным id: " + id + " не найдена.");
                }
            } else if (select == 5) {
                System.out.println("=== Find items by name ===");
                String name = input.askStr("Enter name: ");
                Item[] items = tracker.findByName(name);
                if (items.length > 0) {
                    for (Item item : items) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("Заявки с именем: " + name + " не найдены.");
                }
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
                "Add new Item",
                "Show all items",
                "Edit item",
                "Delete item",
                "Find item by id",
                "Find items by name",
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
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        /*Вызов не статического метода. Необходимо обратиться через объект. */
        new StartUI().init(input, tracker);
    }

}
