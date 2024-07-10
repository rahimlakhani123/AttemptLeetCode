package org.example.arrays;

public class FindMaximumConsecutiveOnes {
    public static void main(String[] args) {
        FindMaximumConsecutiveOnes test = new FindMaximumConsecutiveOnes();
        var result = test.solution(new int[]{1, 1, 0, 1, 1, 1});
        System.out.println(result);

        result = test.solution(new int[]{1, 0, 1, 1, 0, 1});
        System.out.println(result);
    }

    public int solution(int[] nums) {
        int maxOnes = Integer.MIN_VALUE;
        int runningCtr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                runningCtr++;
                maxOnes = Integer.max(runningCtr, maxOnes);
            } else runningCtr = 0;
        }
        return maxOnes;
    }
}
