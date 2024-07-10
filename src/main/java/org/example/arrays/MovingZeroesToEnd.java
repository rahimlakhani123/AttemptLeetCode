package org.example.arrays;

import java.util.Arrays;

public class MovingZeroesToEnd {
    public static void main(String[] args) {
        MovingZeroesToEnd test = new MovingZeroesToEnd();
        test.solution(new int[]{8, 5, 0, 10, 0, 20});
        System.out.println("*************");
        test.solution(new int[]{0, 1, 0, 3, 12});
    }

    public void solution(int[] arr) {
        int sp = 0;

        while (sp < arr.length - 1) {
            if (arr[sp] == 0) {
                int fp = sp + 1;
                while (fp < arr.length - 1 && arr[fp] == 0) {
                    fp++;
                }
                int tmp = arr[sp];
                arr[sp] = arr[fp];
                arr[fp] = tmp;
            }
            sp++;
        }


        Arrays.stream(arr).forEach(System.out::println);
    }
}
