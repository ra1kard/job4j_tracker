package ru.job4j.oop;

public class Error {
    boolean active;
    int status;
    String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println(active);
        System.out.println(status);
        System.out.println(message);
        System.out.println();
    }

    public static void main(String[] args) {
        Error error400 = new Error();
        Error error403 = new Error(true, 403, "Forbidden");
        Error error404 = new Error(true, 404, "Not Found");
        error400.printInfo();
        error403.printInfo();
        error404.printInfo();
    }

}
