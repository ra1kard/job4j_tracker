package ru.job4j.oop;

public class CalculatorThree {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static void main(String[] args) {
        int result1 = CalculatorThree.sum(10);          //статический метод можно вызвать через название "Класса.метод()"
        int result2 = sum(10);                      //статический метод можно вызвать через название "метода()"
        System.out.println(result1);
        System.out.println(result2);

        CalculatorThree calculator2 = new CalculatorThree();
        int rsl = calculator2.multiply(5);          //нестатический метод вызывается через "объект.метод()"
        System.out.println(rsl);

        int rsl2 = calculator2.sum(2);
        System.out.println(rsl2);
    }

}

