package ru.job4j.tracker;

/**
 * исполльзуем на примере шаблон синглтон Singleton
 * как можно было бы создать такой объект:
 * public class StartUI {
 *     public static void main(String[] args) {
 *         Log4File log = Log4File.getInstance();
 *         log.add("add new Item");
 *         log.save();
 *     }
 * }
 */
public final class Log4File {
    private static Log4File instance = null;
    private String[] messages = new String[1000];
    private int index = 0;

    private Log4File() {
    }

    public static Log4File getInstance() {
        if (instance == null) {
            instance = new Log4File();
        }
        return instance;
    }

    public void add(String message) {
        messages[index++] = message;
    }

    /**
     * TODO Сохраняем записи из массива messages в файл.
     */
    public void save() {
    }

}
