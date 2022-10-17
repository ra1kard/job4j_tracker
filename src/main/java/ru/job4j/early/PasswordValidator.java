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
        int valueSpecialSymbol = 0;
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }
        char[] ch = password.toCharArray();
        for (char value : ch) {
            if (valueUpperCase > 0 && valueLowerCase > 0 && valueHasNumber > 0 && valueSpecialSymbol > 0) {
                break;
            }
            if (Character.isUpperCase(value)) {
                valueUpperCase++;
            }
            if (Character.isLowerCase(value)) {
                valueLowerCase++;
            }
            if (Character.isDigit(value)) {
                valueHasNumber++;
            }
            if ((value >= '!' && value <= '/') || (value >= ':' && value <= '@') || (value >= '[' && value <= '`')
                    || (value >= '{' && value <= '~')) {
                valueSpecialSymbol++;
            }
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Длина пароля находится в диапазоне [8, 32]");
        }
        if (valueUpperCase == 0) {
            throw new IllegalArgumentException("Пароль содержит хотя бы один символ в верхнем регистре");
        }
        if (valueLowerCase == 0) {
            throw new IllegalArgumentException("Пароль содержит хотя бы один символ в нижнем регистре");
        }
        if (valueHasNumber == 0) {
            throw new IllegalArgumentException("Пароль содержит хотя бы одну цифру");
        }
        if (valueSpecialSymbol == 0) {
            throw new IllegalArgumentException("Пароль содержит хотя бы один спец. символ (не цифра и не буква)");
        }
        String[] invalidWords = {"qwerty", "12345", "password", "admin", "user"};
        for (String invalidWord : invalidWords) {
            if (password.toLowerCase().contains(invalidWord)) {
                throw new IllegalArgumentException("Пароль не содержит подстрок без учета регистра: qwerty, 12345, "
                        + "password, admin, user.");
            }
        }
        return password;
    }

    public static void main(String[] args) {
        String value = "USRр@зДва345";
        String rsl = validate(value);
        System.out.println(rsl);
    }

}
