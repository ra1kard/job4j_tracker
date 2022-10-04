package ru.job4j.ex;

public class FindEl {

    /**
     * проверяет, что в списке есть ключ шаблона сообщения.
     * Метод может выкинуть исключение ElementNotFoundException.
     */
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                System.out.println("Found item has index: " + i);
                rsl = i;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("Element not found");
        }
        return rsl;
    }

    /**
     * Метод sent отправляет сообщение, если ключ не входит в ключи запрещенных ключей.
     * Метод может выкинуть исключение ElementAbuseException.
     * if contains throw ElementAbuseException
     */
    public static boolean sent(String value, String[] abuses) throws ElementAbuseException {
        for (int i = 0; i < abuses.length; i++) {
            if (abuses[i].equals(value)) {
                throw new ElementAbuseException("Element contains abuse");
            }
        }
        return true;
    }

    /**
     * Далее мы хотим сделать общий метод, который будет проверять, что такой ключ есть и отправлять сообщение.
     */
    public static void process(String[] values, String key, String[] abuses) {
        try {
            if (indexOf(values, key) != -1) {
                sent(key, abuses);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            String[] names = {"Petr", "Ivan", "Evil", "Vasiliy"};
            String[] abuses = {"Radish", "Evil"};
            process(names, "Evil", abuses);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
