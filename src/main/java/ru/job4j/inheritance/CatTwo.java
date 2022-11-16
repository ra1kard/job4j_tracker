package ru.job4j.inheritance;

public class CatTwo extends Animal {

    @Override
    public void instanceInvoke() {
        System.out.println("Вызов метода экземпляра Cat");
    }

    public static void staticInvoke() {
        System.out.println("Вызов статического метода Cat");
    }

}
