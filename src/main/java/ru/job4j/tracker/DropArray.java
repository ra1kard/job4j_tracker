package ru.job4j.tracker;

import java.util.Arrays;

public class DropArray {

    /**
     * src:     массив из которого копируем
     * srcPos:  с какой позиции начинаем копировать
     * dest:    в какой массив скопирую
     * destPos: с какого элемента мне начать вставлять
     * length:  какой длины должен быть мой копированный элемент
     * */
    public static void main(String[] args) {
        String[] names = {"Petr", null, "Ivan", "Stepan", "Fedor"};
        System.arraycopy(names, 2, names, 1, 3);
        System.out.println(Arrays.toString(names));
    }

}
