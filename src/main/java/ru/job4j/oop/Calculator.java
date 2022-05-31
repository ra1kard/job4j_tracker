package ru.job4j.oop;

/**
 * В методе main продемонстрируйте как будете вызывать все созданные методы.
 * Обратите внимание, что для вызова нестатических методов необходимо создавать экземпляр класса.
 * */
public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int a) {
        return a - x;
    }

    public int divide(int a) {
        return a / x;
    }

    public int sumAllOperation(int a) {
        return sum(a) + multiply(a) + minus(a) + divide(a);
    }

    public static void main(String[] args) {
        int result = Calculator.sum(10);
        int result2 = sum(11);
        int result3 = minus(6);
        Calculator calculator = new Calculator();
        int rsl = calculator.multiply(5);
        Calculator calculator2 = new Calculator();
        int rsl2 = calculator2.divide(10);
        Calculator calculator3 = new Calculator();
        int rsl3 = calculator3.sumAllOperation(3);
    }

}
