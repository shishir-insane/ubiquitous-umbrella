/**
 * Given an array A of integers, find the maximum of j - i
 * subjected to the constraint of A[i] <= A[j].
 *
 * Example :
 *
 * A : [3 5 4 2]
 * Output : 2
 * for the pair (3, 4)
 *
 * Input:
 *
 * The first line contains an integer T, depicting total number of test cases.
 * Then following T lines contains an integer N depicting the size of array
 * and next line followed by the value of array.
 *
 * Output:
 *
 * Print the maximum difference of the indexes i and j in a separtate line.
 *
 * Constraints:
 *
 * 1 ≤ T ≤ 100
 * 1 ≤ N ≤ 1000
 * 0 ≤ A[i] ≤ 100
 *
 * Example:
 *
 * Input
 * 1
 * 2
 * 1 10
 *
 * Output
 * 1
 *
 * MaximumIndex.java
 * com.sk.uu.algo
 * ubiquitous-umbrella
 *
 * Copyright 2018 - Shishir Kumar
 *
 */
package com.sk.uu.algo;

import java.util.Scanner;

public class MaximumIndex {

    private static int maxIndexResult;

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0) {
            final int n = in.nextInt();
            final int arr[] = new int[n];
            maxIndexResult = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            findMaxIndexInArray(arr, 0, n - 1);
            System.out.println(maxIndexResult);
        }
        in.close();
    }

    /**
     * Find max index in array.
     *
     * @param arr
     *            the arr
     * @param begin
     *            the begin
     * @param end
     *            the end
     */
    private static void findMaxIndexInArray(final int[] arr, final int begin, final int end) {
        if (end - begin < maxIndexResult) {
            return;
        }
        if (arr[begin] <= arr[end]) {
            if (end - begin > maxIndexResult) {
                maxIndexResult = end - begin;
            }
        }
        if (begin < arr.length - 1) {
            findMaxIndexInArray(arr, begin + 1, end);
        }
        if (end > 0) {
            findMaxIndexInArray(arr, begin, end - 1);
        }
    }
}
