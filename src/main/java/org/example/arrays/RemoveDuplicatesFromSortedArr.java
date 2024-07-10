package org.example.arrays;

import java.util.Arrays;
import java.util.HashSet;

public class RemoveDuplicatesFromSortedArr {
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArr test = new RemoveDuplicatesFromSortedArr();
        test.solution(new int[]{10, 20, 20, 30, 30, 30, 30});

        System.out.println("***********");
        test.solution(new int[]{10, 10, 10});
    }

    public void solution(int[] arr) {
        HashSet<Integer> duplicateChecker = new HashSet<>();
        int newCtr = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!duplicateChecker.contains(arr[i])) {
                duplicateChecker.add(arr[i]);
                arr[newCtr++] = arr[i];
            }
        }
        while (newCtr < arr.length)
            arr[newCtr++] = 0;

        Arrays.stream(arr).forEach(System.out::println);
    }
}
