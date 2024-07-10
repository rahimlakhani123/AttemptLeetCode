package org.example.arrays;

public class MaximumSumOfKConsecutiveElements {
    public static void main(String[] args) {
        MaximumSumOfKConsecutiveElements elements = new MaximumSumOfKConsecutiveElements();
        var maxSum = elements.solutionWithSlidingWindow(new int[]{1, 8, 30, -5, 20, 7}, 3);
        System.out.println(maxSum);
        var maxSum2 = elements.solutionWithSlidingWindow(new int[]{5, -10, 6, 90, 3}, 2);
        System.out.println(maxSum2);
    }

    public int solution(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            int ctr = 0;
            while (ctr < k && ctr + i < nums.length) {
                sum = sum + nums[i + ctr];
                max = Math.max(max, sum);
                ctr++;
            }
            System.out.println("for i" + i + "max is " + max);
        }
        return max;
    }


    public int solutionWithSlidingWindow(int[] nums, int k) {
        int firstWindowSum = 0;
        for (int i = 0; i < k; i++) {
            firstWindowSum = firstWindowSum + nums[i];
        }

        int response = firstWindowSum;

        for (int i = k; i < nums.length; i++) {
            firstWindowSum = firstWindowSum + nums[i] - nums[i - k];
            response = Math.max(firstWindowSum, response);
        }
        return response;

    }
}
