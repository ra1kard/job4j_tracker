package ru.job4j.ooa;

import java.util.Objects;

public final class Airbus extends Aircraft {
    private static final int COUNT_ENGINE = 2;
    private String name;

    public Airbus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void printModel() {
        System.out.println("Модель самолета: " + name);
    }

    /**
     * метод printCountEngine() должен выводить реальное количество двигателей,
     * которое присуще той или иной модели самолета.
     * Поэтому если модель самолета A380 - количество двигателей должно равняться 4,
     * для всех остальных моделей - используем в качестве значения константу COUNT_ENGINE.
     */
    public void printCountEngine() {
        int count = Objects.equals(name, "A380") ? 4 : COUNT_ENGINE;
        System.out.println("Количество двигателей равно: " + count);
    }

    @Override
    public String toString() {
        return "Airbus{"
                + "name='" + name + '\''
                + '}';
    }

}
