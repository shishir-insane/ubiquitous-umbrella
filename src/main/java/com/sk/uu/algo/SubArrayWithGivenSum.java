/**
 * Given an unsorted array of non-negative integers,
 * find a continuous sub-array which adds to a given number.
 *
 * Input:
 * The first line of input contains an integer T denoting the number of test cases.
 * Then T test cases follow. Each test case consists of two lines.
 * The first line of each test case is N and S, where N is the size of array and S is the sum.
 * The second line of each test case contains N space separated integers denoting the array elements.
 *
 * Output:
 * Corresponding to each test case, in a new line,
 * print the starting and ending positions of first such occuring subarray if sum equals to
 * subarray, else print -1.
 *
 * Note: Position of 1st element of the array should be considered as 1.
 *
 * Expected Time Complexity: O(n)
 *
 * Constraints:
 * 1 ≤ T ≤ 100
 * 1 ≤ N ≤ 100
 * 1 ≤ an array element ≤ 200
 *
 * Example:
 *
 * Input:
 * 2
 * 5 12
 * 1 2 3 7 5
 * 10 15
 * 1 2 3 4 5 6 7 8 9 10
 *
 * Output:
 * 2 4
 * 1 5
 *
 * Explanation :
 * In first test case, sum of elements from 2nd position to 4th position is 12
 * In second test case, sum of elements from 1st position to 5th position is 15
 *
 * SubArrayWithGivenSum.java
 * com.sk.uu.algo
 * ubiquitous-umbrella
 *
 * Copyright 2018 - Shishir Kumar
 */

package com.sk.uu.algo;

import java.util.Scanner;

public class SubArrayWithGivenSum {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) {
        final Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            final int n = sc.nextInt();
            final int sum = sc.nextInt();
            final int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            findSubarrayWithSum(a, n, sum);
            t--;
        }
    }

    /**
     * Find subarray with sum.
     *
     * @param a
     *            the a
     * @param n
     *            the n
     * @param sum
     *            the sum
     */
    public static void findSubarrayWithSum(final int a[], final int n, final int sum) {
        int start = 0;
        int tempSum = a[0];
        for (int i = 1; i < n; i++) {
            tempSum += a[i];
            while (start < i && tempSum > sum) {
                tempSum -= a[start];
                start++;
            }
            if (tempSum == sum) {
                System.out.println(start + 1 + " " + (i + 1));
                return;
            }
        }
        System.out.println(-1);
    }
}
