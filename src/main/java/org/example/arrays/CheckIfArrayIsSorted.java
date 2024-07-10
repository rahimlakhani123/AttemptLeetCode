package org.example.arrays;

public class CheckIfArrayIsSorted {
    public static void main(String[] args) {
        CheckIfArrayIsSorted check = new CheckIfArrayIsSorted();
        System.out.println(check.isSorted(new int[]{8, 12, 15}));
        System.out.println(check.isSorted(new int[]{8, 10, 10, 12}));
        System.out.println(check.isSorted(new int[]{}));
        System.out.println(check.isSorted(new int[]{80, 10, 5}));
    }

    public boolean isSorted(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1])
                return false;
        }
        return true;
    }
}
