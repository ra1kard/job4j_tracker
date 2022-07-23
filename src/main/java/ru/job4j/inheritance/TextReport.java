package ru.job4j.inheritance;

/**
 * look class HtmlReport and ReportUsage
 */
public class TextReport {

    public String generate(String name, String body) {
        return name + System.lineSeparator() + body;
    }

}
