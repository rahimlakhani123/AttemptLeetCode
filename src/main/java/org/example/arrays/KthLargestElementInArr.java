package org.example.arrays;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElementInArr {
    public static void main(String[] args) {
        KthLargestElementInArr arr = new KthLargestElementInArr();
        var result = arr.solution(new int[]{3, 2, 1, 5, 6, 4}, 2);
        System.out.println(result);
    }

    public int solution(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            q.add(num);
        }
        while (k-- > 1) {
            q.poll();
        }
        return q.poll();
    }
}
