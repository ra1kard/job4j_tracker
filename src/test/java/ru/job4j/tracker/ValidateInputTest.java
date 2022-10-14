package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ValidateInputTest {

    /**
     * Тест whenInvalidInput проверяет ситуацию, когда пользователь ввел сначала неверные данные, а потом верные.
     */
    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    public void whenMultipleValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1", "2", "3"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Menu:");
        int selectedTwo = input.askInt("Menu:");
        int selectedThree = input.askInt("Menu:");
        assertThat(selected).isEqualTo(1);
        assertThat(selectedTwo).isEqualTo(2);
        assertThat(selectedThree).isEqualTo(3);
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    public void whenValidInputNegativeNumber() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"-2"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Menu:");
        assertThat(selected).isEqualTo(-2);
    }

}
