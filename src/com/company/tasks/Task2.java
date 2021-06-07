package com.company.tasks;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task2 {

    public static void solution() {
        Scanner scan = new Scanner(System.in);
        int sum;

        System.out.println("-----------------");
        System.out.println("Task 2");

        System.out.println("Enter the sum of pairs of numbers");
        sum = scan.nextInt();

        Task1.getInfo();

        start(sum, Task1.getIntegerList());
    }

    private static void start(int sum, List<Integer> integerList) {

        //long startTimer = System.currentTimeMillis();

        integerList.stream()
                .parallel()
                .filter(o1 -> o1 <= (sum / 2))
                .filter(o1 -> integerList.contains(sum - o1))
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList())
                .forEach(o2 -> System.out.println(o2 + " : " + (sum - o2)));

        //System.out.println((System.currentTimeMillis() - startTimer) + " ms");
    }
}
