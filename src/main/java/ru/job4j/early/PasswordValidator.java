package ru.job4j.early;

/**
 * Условно, принцип раннего возврата = if + return,
 * а принцип охранных выражений = if + throws.
 */
public class PasswordValidator {

    public static String validate(String password) {
        int valueUpperCase = 0;
        int valueLowerCase = 0;
        int valueHasNumber = 0;
        int valueSpecific = 0;
        String conditions = """
                1) Длина пароля находится в диапазоне [8, 32];
                2) Пароль содержит хотя бы один символ в верхнем регистре;
                3) Пароль содержит хотя бы один символ в нижнем регистре;
                4) Пароль содержит хотя бы одну цифру;
                5) Пароль содержит хотя бы один спец. символ (не цифра и не буква);
                6) Пароль не содержит подстрок без учета регистра: qwerty, 12345, password, admin, user. Без учета регистра, значит что, например, ни qwerty ни QWERTY ни qwErty и т.п. не должно быть в составе пароля.""";
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            return conditions;
        }
        char[] ch = password.toCharArray();
        for (char value : ch) {
            if (Character.isUpperCase(value)) {
                valueUpperCase++;
                continue;
            }
            if (Character.isLowerCase(value)) {
                valueLowerCase++;
                continue;
            }
            if (Character.isDigit(value)) {
                valueHasNumber++;
                continue;
            }
            if (value >= '!' && value <= '/') {
                valueSpecific++;
                continue;
            }
        }
        if (password.toLowerCase().contains("qwerty")
                || password.toLowerCase().contains("12345")
                || password.toLowerCase().contains("password")
                || password.toLowerCase().contains("admin")
                || password.toLowerCase().contains("user")) {
            return conditions;
        }
        if (valueUpperCase == 0 || valueLowerCase == 0 || valueHasNumber == 0 || valueSpecific == 0) {
            return conditions;
        }
        return password;
    }

    public static void main(String[] args) {
        String value = "раздват";
        String rsl = validate(value);
        System.out.println(rsl);
    }

}
