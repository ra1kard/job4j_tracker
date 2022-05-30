package ru.job4j.oop;

public class DummyDic {

    String engToRus(String eng) {
        String answer = "Неизвестное слово. ";
        return answer + eng;
    }

    public static void main(String[] args) {
        DummyDic alex = new DummyDic();
        String random = "coach";
        alex.engToRus(random);
    }

}
