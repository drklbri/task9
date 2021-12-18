package ru.vsu.cs.shevchenko_daniil;

import java.util.List;

public class MaxSumRange {
    public int start, end, sum;

    public MaxSumRange(int start, int end, int sum) {
        this.end = end;
        this.start = start;
        this.sum = sum;
    }

    public static MaxSumRange ListIndex(List<Integer> list) {
        int currSum = 0;
        int startIndex = 0;
        int maxSum = maxSumInSubArray(list);
        MaxSumRange maxSumRange = null;

        for (int endIndex = 0; endIndex < list.size(); endIndex++) {
            currSum += list.get(endIndex);

            if (maxSumRange == null || currSum >= maxSumRange.sum) {
                if (currSum == maxSum && maxSumRange != null && endIndex - startIndex == maxSumRange.end - maxSumRange.start && maxSumRange.end != endIndex)
                    continue;
                maxSumRange = new MaxSumRange(startIndex, endIndex, currSum);
            }

            if (currSum < 0) {
                currSum = 0;
                startIndex = endIndex + 1;
            }
        }
        return maxSumRange;
    }

    public static int maxSumInSubArray(List<Integer> list) {
        int maxSum = 0;
        int currSum = 0;

        for (int numbers : list) {
            currSum = Math.max(0, numbers + currSum);
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }
}
