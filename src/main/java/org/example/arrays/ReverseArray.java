package org.example.arrays;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        ReverseArray ra = new ReverseArray();
        ra.solution(new int[]{10, 5, 7, 30});
    }

    public void solution(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
        Arrays.stream(arr).forEach(System.out::println);
    }
}
