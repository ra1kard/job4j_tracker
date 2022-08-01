package ru.job4j.oop;

public class Plane implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " летит по воздуху");
    }

    @Override
    public void characteristic() {
        System.out.println(getClass().getSimpleName() + " максимальная скорость - 2650 км/ч");
    }

}
