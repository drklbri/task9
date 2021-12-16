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
       MaxSumRange maxSumRange = null;

       for (int endIndex = 0; endIndex < list.size(); endIndex++) {
           currSum += list.get(endIndex);

           if (maxSumRange == null || currSum > maxSumRange.sum)
               maxSumRange = new MaxSumRange(startIndex, endIndex, currSum);

           if (currSum < 0) {
               currSum = 0;
               startIndex = endIndex + 1;
           }
       }
       return maxSumRange;
    }
}
