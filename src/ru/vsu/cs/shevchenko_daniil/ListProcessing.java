package ru.vsu.cs.shevchenko_daniil;

import ru.vsu.cs.shevchenko_daniil.utils.ArrayUtils;

import java.util.*;

public class ListProcessing {

   public static List<Integer> createNewList(List<Integer> list) {
        MaxSumRange maxSumIndex = MaxSumRange.ListIndex(list);
        int startIndex = maxSumIndex.start;
        int endIndex = maxSumIndex.end;

        List<Integer> newList = new ArrayList<>();


        for (int index = 0; index < list.size(); index++) {
            if (startIndex <= index && index <= endIndex) {
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