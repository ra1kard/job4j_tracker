package ru.job4j.oop;

public class BallStory {

    public static void main(String[] args) {
        Ball ball = new Ball();
        Fox fox = new Fox();
        Wolf wolf = new Wolf();
        Hare hare = new Hare();
        hare.tryEat(ball);
        ball.tryRun(false);
        wolf.tryEat(ball);
        ball.tryRun(false);
        fox.tryEat(ball);
        ball.tryRun(true);
    }

}
