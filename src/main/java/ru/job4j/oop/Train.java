package ru.job4j.oop;

public class Train implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " движется по рельсам");
    }

    @Override
    public void characteristic() {
        System.out.println(getClass().getSimpleName() + " максимальная скорость - 580 км/ч");
    }

}
