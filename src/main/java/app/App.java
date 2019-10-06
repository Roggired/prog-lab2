/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package app;

import java.util.Scanner;

import lab.Lab;

/**
 * Main-Class лабораторной.
 * Отвечает за чтение имени проверяющего и запуск лабораторной
 * @author Егошин Алексей Васильевич, ВТ, Р3113
 * @version 0.1.0alpha
 */
public class App {
    private static final String GREETINGS = "Пожалуйста, введите имя принимающего лабораторную:";
    private static final String STUDENT_NAME = "Алексей";
    

    /**
     * Точка входа в программу
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        System.out.println(GREETINGS);
        
        Scanner scanner = new Scanner(System.in);
        String validatorName = scanner.next();
        scanner.close();

        Lab lab = new Lab(validatorName, 
                          STUDENT_NAME);
        lab.start();
    }
}
