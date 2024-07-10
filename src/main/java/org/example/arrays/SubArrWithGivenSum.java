package org.example.arrays;

public class SubArrWithGivenSum {
    public static void main(String[] args) {
        SubArrWithGivenSum subArrWithGivenSum = new SubArrWithGivenSum();
        var isPresent = subArrWithGivenSum.solution(new int[]{1, 4, 20, 3, 10, 5}, 33);
        System.out.println(isPresent);
    }

    public boolean solution(int[] nums, int target) {
        int slowPtr = 0;
        int curr = 0;
        for (int fastPtr = 0; fastPtr < nums.length; fastPtr++) {
            curr += nums[fastPtr];
            while (curr > target) {
                curr -= nums[slowPtr++];
            }
            if (curr == target)
                return true;
        }
        return false;
    }
}
