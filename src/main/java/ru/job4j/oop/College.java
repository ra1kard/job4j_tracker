package ru.job4j.oop;

public class College {

    //В нем сделайте приведение объекта Freshman к Student, а потом к Object.
    public static void main(String[] args) {
        /* создаем объекта класса Freshman. */
        Freshman freshman = new Freshman();
        /* делаем приведение к типу родителя Student. */
        Student st = freshman;
        /* делаем приведение к типу родителя Object. */
        Object obj = freshman;
    }

}
