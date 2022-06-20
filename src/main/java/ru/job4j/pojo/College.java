package ru.job4j.pojo;

import java.util.Date;

public class College {

    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Stanislav Kufarev");
        student.setGroup("102");
        student.setEntering(new Date());

        System.out.println(student.getFio() + " in the group: "
                + student.getGroup() + " since " + student.getEntering());
    }

}
