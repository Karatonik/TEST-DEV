package com.company;

import com.company.tasks.Task1;
import com.company.tasks.Task2;
import com.company.tasks.Task3;

import java.util.Scanner;

public class MyMenu {

    public static void init() {
        System.out.println("Hello, choose one of the tasks");

        Scanner scan = new Scanner(System.in);

        while (true) {
            drawGui();
            switch (scan.nextInt()) {

                case 1: {
                    Task1.solution();
                    break;
                }
                case 2: {
                    Task2.solution();
                    break;
                }
                case 3: {
                    Task3.solution();
                    break;
                }
                case 4: {
                    System.exit(0);
                    break;
                }
            }
        }
    }

    private static void drawGui() {
        System.out.println("------------------------------------------------");
        System.out.println("To select a task press the NUMBER and then ENTER");
        System.out.println("+-----------------+");
        System.out.println("|Task 1. Press [1]|");
        System.out.println("|Task 2. Press [2]|");
        System.out.println("|Task 3. Press [3]|");
        System.out.println("|Exit  . Press [4]|");
        System.out.println("+-----------------+");
    }

}
