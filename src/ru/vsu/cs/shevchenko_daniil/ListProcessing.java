package ru.vsu.cs.shevchenko_daniil;

import ru.vsu.cs.shevchenko_daniil.utils.ArrayUtils;

import java.util.*;

public class ListProcessing {

    public static List<Integer> createNewList(List<Integer> list) {

        List<Integer> tempList = MaxSumRange.ListIndex(list);
        List<Integer> newList = new ArrayList<>();

        int[] shortestSubArray = new int[2];
        int minDist = 10000;

        for (int i = 1; i < tempList.size(); i += 2) {
            if ((i) - (i - 1) < minDist) {
                minDist = tempList.get(i) - tempList.get(i-1);
                shortestSubArray[0] = tempList.get(i-1);
                shortestSubArray[1] = tempList.get(i);
            }
        }

        for (int index = 0; index < list.size(); index++) {
            if (shortestSubArray[0] <= index && index <= shortestSubArray[1]) {
                newList.add(list.get(index));
            }
        }

        return newList;
    }


    public static void readList(List<Integer> list) {
        Scanner sc = new Scanner(System.in);
        String listString = sc.nextLine();
        String[] numbers = listString.split(" ");
        for (String number : numbers) {
            list.add(Integer.parseInt(number));
        }
    }

    public static List<Integer> intArrayToList(int[] array) {
        return Arrays.asList(ArrayUtils.toObject(array));
    }

    public static int[] fromListToIntArray(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static <T> void printCollection(Collection<T> collection) {
        boolean first = true;
        for (T item : collection) {
            System.out.print((first ? "" : ", ") + item);
            first = false;
        }
        System.out.println();
    }

    public static List<Integer> readLineFromFile(String fileName) {
        return intArrayToList(ArrayUtils.readIntArrayFromFile(fileName));
    }
}