package org.example.arrays;

public class MaxSubArray {
    public static void main(String[] args) {
        MaxSubArray sa = new MaxSubArray();
        var max = sa.maxSubArr(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(max);
    }

    public int maxSubArr(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE, sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            max = Math.max(sum, max);

            if (sum < 0) sum = 0;
        }

        return max;
    }
}
