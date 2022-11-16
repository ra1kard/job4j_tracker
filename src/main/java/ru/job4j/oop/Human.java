package ru.job4j.oop;

public class Human {
    int age;
    int weight;
    int height;

    Human(int age, int weight) {
        this.age = age;
        this.weight = weight;
    }

    Human(int age, int weight, int height) {
        this(age, weight);      //вы вызываете конструктор с двумя параметрами
        this.height = height;   //и добавляете недостающую переменную
    }

}

