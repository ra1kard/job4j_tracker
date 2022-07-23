package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void go() {
        System.out.println("Bus отправился в путь!");
    }

    @Override
    public void passengers(int countPeople) {
        if (countPeople < 18) {
            System.out.println("Вам подойдёт Mercedes Sprinter.");
        } else {
            System.out.println("Вам подойдёт ЛиАЗ-6213.");
        }
    }

    @Override
    public int refuel(int amountOfFuel) {
        int priceAi95 = 44;
        return priceAi95 * amountOfFuel;
    }

}
