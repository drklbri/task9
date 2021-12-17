package ru.vsu.cs.shevchenko_daniil;

import java.util.ArrayList;
import java.util.List;

public class MaxSumRange {
    public int start, end, sum;

    public MaxSumRange(int start, int end, int sum) {
        this.end = end;
        this.start = start;
        this.sum = sum;
    }

    public static List<Integer> ListIndex(List<Integer> list) {
        int currSum = 0;
        int startIndex = 0;
        MaxSumRange maxSumRange = null;
        int maxSum = maxSumOfSubArray(list);
        List<Integer> tempList = new ArrayList<>();

        for (int endIndex = 0; endIndex < list.size(); endIndex++) {
            currSum += list.get(endIndex);

            if (maxSumRange == null || currSum > maxSumRange.sum) {
                maxSumRange = new MaxSumRange(startIndex, endIndex, currSum);
            }

            if (currSum < 0) {
                currSum = 0;
                startIndex = endIndex + 1;
            }
            if (currSum == maxSum) {
                tempList.add(startIndex);
                tempList.add(endIndex);
            }
        }
        return tempList;
    }

    public static int maxSumOfSubArray(List<Integer> list) {
        int currSum = 0;
        int maxSum = 0;
        for (int number : list) {
            currSum = Math.max(0, number+currSum);
            maxSum = Math.max(currSum,maxSum);
        }
        return maxSum;
    }

}
