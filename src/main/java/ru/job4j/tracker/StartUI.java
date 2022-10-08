package ru.job4j.tracker;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    /**
     * инициализирует приложение и запускает выполнение различных пользовательских действий;
     */
    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.length) {
                out.println("Wrong input, you can select: 0 .. " + (actions.length - 1));
                continue;
            }
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    /**
     * выводит на экран меню доступных пользовательских действий;
     * 0. Add new Item          1. Добавление заявки;       add             CreateAction
     * 1. Show all items        2. Вывод всех заявок;       findAll         ShowAllAction
     * 2. Edit item             3. Изменение заявки;        replace         ReplaceAction
     * 3. Delete item           4. Удаление заявки;         delete          DeleteAction
     * 4. Find item by id       5. Вывод заявки по id;      findById        FindByIdAction
     * 5. Find items by name    6. Вывод заявок по имени.   findByName      FindByNameAction
     * 6. Exit Program
     */
    private void showMenu(UserAction[] actions) {
        out.println("Menu:");
        for (int index = 0; index < actions.length; index++) {
            out.println(index + ". " + actions[index].name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {new CreateAction(output),
                new ShowAllAction(output),
                new ReplaceAction(output),
                new DeleteAction(output),
                new FindByIdAction(output),
                new FindByNameAction(output),
                new Exit(output)};
        new StartUI(output).init(input, tracker, actions);
    }

}
