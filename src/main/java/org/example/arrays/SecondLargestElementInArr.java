package org.example.arrays;

public class SecondLargestElementInArr {
    public static void main(String[] args) {
        SecondLargestElementInArr sol = new SecondLargestElementInArr();
        var result = sol.solution(new int[]{10, 5, 8, 20}, 2);
        System.out.println(result);

        var result2 = sol.solution(new int[]{20, 10, 20, 8, 12}, 2);
        System.out.println(result2);
    }

    public int solution(int[] nums, int k) {
        // l , sl
        int l = Integer.MIN_VALUE;
        int sl = l;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= l) {
                l = nums[i];
            } else if (nums[i] < l && sl < nums[i]) {
                sl = nums[i];
            } else if (nums[i] < l && sl == Integer.MIN_VALUE) {
                sl = l;
            }
        }
        return sl;
    }
}
