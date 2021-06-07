package com.company.tasks;

import java.util.*;
import java.util.stream.Collectors;

public class Task1 {

    public static void solution() {

        System.out.println("-----------------");
        System.out.println("Task 1");

        getInfo();
        start(getIntegerList());
    }

    private static void start(List<Integer> integerList) {

        //long startTimer = System.currentTimeMillis();

        showList(integerList.stream().parallel()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList()));

        System.out.println("count: " + integerList.size());

        System.out.println("distinct: " + (int) integerList.stream().parallel().distinct().count());

        integerList.stream().min(Comparator.naturalOrder()).ifPresent(min -> System.out.println("min: " + min));

        integerList.stream().max(Comparator.naturalOrder()).ifPresent(max -> System.out.println("max: " + max));

       // System.out.println((System.currentTimeMillis() - startTimer) + " ms");
    }

    private static void showList(List<Integer> integerList) {
        System.out.println(integerList.toString()
                .replace("[", "")
                .replace("]", ""));
    }

    public static void getInfo() {
        System.out.println("------------------------------------------------");
        System.out.println("Write integers using the separator \" \" and next press Enter");
        System.out.println("Press ENTER without value to finish");
    }

    public static List<Integer> getIntegerList() {
        String tempStr;
        List<Integer> tempIntegerList = new ArrayList<>();

        Scanner scan = new Scanner(System.in);

        do {
            tempStr = scan.nextLine();

            try {
                List<String> stringList = Arrays.asList(tempStr.split(" "));
                stringList.stream()
                        .parallel()
                        .forEach(str -> tempIntegerList.add(Integer.parseInt(str.replace("-", ""))));

            } catch (NumberFormatException ex) {
                ex.getMessage();
            }

        } while (!tempStr.isEmpty());

        return tempIntegerList;
    }

}
