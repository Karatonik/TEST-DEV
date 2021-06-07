package com.company.tasks;

import java.util.*;

public class Task3 {

    public static void solution() {
        String tempStr;
        int input1 = 0;
        int input2 = 0;

        Set<Integer> allIntegerSet = new HashSet<>();

        Set<Set<Integer>> graphSet = new HashSet<>();

        Scanner scan = new Scanner(System.in);

        System.out.println("Press ENTER without value to finish");
        do {
            tempStr = scan.nextLine();
            if (!tempStr.isEmpty()) {
                List<String> stringList = Arrays.asList(tempStr.split(" "));

                if (stringList.size() == 2) {

                    try {
                        input1 = Integer.parseInt(stringList.get(0).replace("-", ""));
                        input2 = Integer.parseInt(stringList.get(1).replace("-", ""));

                    } catch (NumberFormatException ex) {
                        System.out.println("invalid format");
                    }
                    int finalInteger1 = input1;
                    int finalInteger2 = input2;

                    if (!allIntegerSet.contains(input1) && !allIntegerSet.contains(input2)) {

                        Set<Integer> integerSet = new HashSet<>();
                        integerSet.add(input1);
                        integerSet.add(input2);
                        graphSet.add(integerSet);

                        allIntegerSet.add(input1);
                        allIntegerSet.add(input2);

                    } else if (allIntegerSet.contains(input1) && allIntegerSet.contains(input2)) {
                        //Optional.get()' without 'isPresent()' I know it, but i check it by allIntegerSet
                        //find int 1
                        Set<Integer> tempSetDecimal1 = graphSet.stream().filter(v -> v.contains(finalInteger1)).findFirst().get();
                        graphSet.remove(tempSetDecimal1);
                        //find int 2
                        Set<Integer> tempSetDecimal2 = graphSet.stream().filter(v -> v.contains(finalInteger2)).findFirst().get();
                        graphSet.remove(tempSetDecimal2);
                        //join
                        tempSetDecimal1.addAll(tempSetDecimal2);
                        graphSet.add(tempSetDecimal1);

                    } else if (allIntegerSet.contains(input1)) {

                        graphSet.forEach(v -> {
                            if (v.contains(finalInteger1)) {
                                graphSet.remove(v);

                                v.add(finalInteger2);
                                graphSet.add(v);

                                allIntegerSet.add(finalInteger2);
                            }
                        });

                    } else if (allIntegerSet.contains(input2)) {
                        graphSet.forEach(v -> {
                            if (v.contains(finalInteger2)) {
                                graphSet.remove(v);

                                v.add(finalInteger1);
                                graphSet.add(v);

                                allIntegerSet.add(finalInteger1);
                            }
                        });
                    }

                    //System.out.println(graphSet);

                } else if (stringList.size() == 1) {

                    try {
                        input1 = Integer.parseInt(stringList.get(0).replace("-", ""));
                    } catch (NumberFormatException ex) {
                        System.out.println("invalid format");
                    }

                    if (!allIntegerSet.contains(input1)) {

                        Set<Integer> integerSet = new HashSet<>();

                        integerSet.add(input1);
                        graphSet.add(integerSet);

                        allIntegerSet.add(input1);

                        //System.out.println(graphSet);
                    }
                } else {
                    System.out.println("invalid format");
                }

            }
        } while (!tempStr.isEmpty());
        System.out.println(graphSet.size() + " graphs are obtained. They are as follows :");
        graphSet.forEach(System.out::println);
    }
}
