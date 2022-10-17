package ru.job4j.early;

import org.junit.jupiter.api.Test;
import ru.job4j.ex.Fact;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PasswordValidatorTest {

    @Test
    public void passwordValid() {
        String value = "р@зДва345";
        String rsl = PasswordValidator.validate(value);
        assertThat(rsl).isEqualTo("р@зДва345");
    }

    @Test
    public void passwordCannotBeNull() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate(null);
                });
        assertThat(exception.getMessage()).isEqualTo("Password cannot be null");
    }

    @Test
    public void lengthPasswordIsSevenInvalid() {
        String value = "р@зДва3";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate(value);
                });
        assertThat(exception.getMessage()).isEqualTo("Длина пароля находится в диапазоне [8, 32]");
    }

    @Test
    public void lengthPasswordIsThirtyThreeInvalid() {
        String value = "!3446789012344678901234467890ыАаа";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate(value);
                });
        assertThat(exception.getMessage()).isEqualTo("Длина пароля находится в диапазоне [8, 32]");
    }

    @Test
    public void passwordHasNoUpperCase() {
        String value = "р@здва345";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate(value);
                });
        assertThat(exception.getMessage()).isEqualTo("Пароль содержит хотя бы один символ в верхнем регистре");
    }

    @Test
    public void passwordHasNoLowerCase() {
        String value = "Р@ЗДВА345";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate(value);
                });
        assertThat(exception.getMessage()).isEqualTo("Пароль содержит хотя бы один символ в нижнем регистре");
    }

    @Test
    public void passwordHasNoNumber() {
        String value = "р@зДватрич";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate(value);
                });
        assertThat(exception.getMessage()).isEqualTo("Пароль содержит хотя бы одну цифру");
    }

    @Test
    public void passwordHasNoSpecialSymbol() {
        String value = "разДва345";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate(value);
                });
        assertThat(exception.getMessage()).isEqualTo("Пароль содержит хотя бы один спец. символ (не цифра и не буква)");
    }

    @Test
    public void passwordHasForbiddenWordQwertyFirstTime() {
        String value = "р@зДваqwerty345шесть";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate(value);
                });
        assertThat(exception.getMessage()).isEqualTo("Пароль не содержит подстрок без учета регистра: qwerty, 12345, "
                + "password, admin, user.");
    }

    @Test
    public void passwordHasForbiddenWordQwertySecondTime() {
        String value = "р@зДваQWERTY345шесть";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate(value);
                });
        assertThat(exception.getMessage()).isEqualTo("Пароль не содержит подстрок без учета регистра: qwerty, 12345, "
                + "password, admin, user.");
    }

    @Test
    public void passwordHasForbiddenWordQwertyThirdTime() {
        String value = "р@зДваqWErty345шесть";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate(value);
                });
        assertThat(exception.getMessage()).isEqualTo("Пароль не содержит подстрок без учета регистра: qwerty, 12345, "
                + "password, admin, user.");
    }

    @Test
    public void passwordHasForbiddenNumbers12345FirstTime() {
        String value = "р@зДва12345шесть";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate(value);
                });
        assertThat(exception.getMessage()).isEqualTo("Пароль не содержит подстрок без учета регистра: qwerty, 12345, "
                + "password, admin, user.");
    }

    @Test
    public void passwordHasForbiddenNumbers12345SecondTime() {
        String value = "р@зДва0123456шесть";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate(value);
                });
        assertThat(exception.getMessage()).isEqualTo("Пароль не содержит подстрок без учета регистра: qwerty, 12345, "
                + "password, admin, user.");
    }

    @Test
    public void passwordHasForbiddenWordPasswordFirstTime() {
        String value = "р@зДва345password";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate(value);
                });
        assertThat(exception.getMessage()).isEqualTo("Пароль не содержит подстрок без учета регистра: qwerty, 12345, "
                + "password, admin, user.");
    }

    @Test
    public void passwordHasForbiddenWordPasswordSecondTime() {
        String value = "р@зДва345PASSWORD";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate(value);
                });
        assertThat(exception.getMessage()).isEqualTo("Пароль не содержит подстрок без учета регистра: qwerty, 12345, "
                + "password, admin, user.");
    }

    @Test
    public void passwordHasForbiddenWordPasswordThirdTime() {
        String value = "р@зДва345paSSword";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate(value);
                });
        assertThat(exception.getMessage()).isEqualTo("Пароль не содержит подстрок без учета регистра: qwerty, 12345, "
                + "password, admin, user.");
    }

    @Test
    public void passwordHasForbiddenWordAdminFirstTime() {
        String value = "р@зДва345admin";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate(value);
                });
        assertThat(exception.getMessage()).isEqualTo("Пароль не содержит подстрок без учета регистра: qwerty, 12345, "
                + "password, admin, user.");
    }

    @Test
    public void passwordHasForbiddenWordAdminSecondTime() {
        String value = "р@зДва345ADMIN";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate(value);
                });
        assertThat(exception.getMessage()).isEqualTo("Пароль не содержит подстрок без учета регистра: qwerty, 12345, "
                + "password, admin, user.");
    }

    @Test
    public void passwordHasForbiddenWordAdminThirdTime() {
        String value = "р@зДва345ADMin";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate(value);
                });
        assertThat(exception.getMessage()).isEqualTo("Пароль не содержит подстрок без учета регистра: qwerty, 12345, "
                + "password, admin, user.");
    }

    @Test
    public void passwordHasForbiddenWordUserFirstTime() {
        String value = "userр@зДва345";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate(value);
                });
        assertThat(exception.getMessage()).isEqualTo("Пароль не содержит подстрок без учета регистра: qwerty, 12345, "
                + "password, admin, user.");
    }

    @Test
    public void passwordHasForbiddenWordUserSecondTime() {
        String value = "USERр@зДва345";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate(value);
                });
        assertThat(exception.getMessage()).isEqualTo("Пароль не содержит подстрок без учета регистра: qwerty, 12345, "
                + "password, admin, user.");
    }

    @Test
    public void passwordHasForbiddenWordUserThirdTime() {
        String value = "USerр@зДва345";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate(value);
                });
        assertThat(exception.getMessage()).isEqualTo("Пароль не содержит подстрок без учета регистра: qwerty, 12345, "
                + "password, admin, user.");
    }

}
