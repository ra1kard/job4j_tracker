package ru.job4j.oop;

public class Bus implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " движется по скоростной трассе");
    }

    @Override
    public void characteristic() {
        System.out.println(getClass().getSimpleName() + " максимальная скорость - 590 км/ч");
    }

}
