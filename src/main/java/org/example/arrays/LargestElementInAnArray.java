package org.example.arrays;

public class LargestElementInAnArray {
    public static void main(String[] args) {
        LargestElementInAnArray test = new LargestElementInAnArray();
        int result = test.solution(new int[]{40, 8, 50, 100});
        System.out.println(result);
        assert result == 3;
    }

    public int solution(int[] arr) {
        int largestEle = Integer.MIN_VALUE;
        int largestEleIdx = -1;
        for (int i = 0; i < arr.length; i++) {
            if (Math.max(largestEle, arr[i]) == arr[i]) {
                largestEle = arr[i];
                largestEleIdx = i;
            }

        }
        return largestEleIdx;
    }
}
