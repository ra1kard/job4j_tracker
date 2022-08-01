package ru.job4j.oop;

public class GuineaPig implements Animal {

    @Override
    public void sound() {
        System.out.println(getClass().getSimpleName() + "Громко пищит для привлечения внимания");
    }

}
