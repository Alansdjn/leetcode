package com.wei.leetcode.problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wei wang
 * @date 2020/08/16
 */
public class P77Combinations {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int n = 20;
        int k = 16;
        List<List<Integer>> r = new P77Combinations().new Solution().combine(n, k);
        r.forEach(item -> {
            item.forEach(e -> {
                System.out.print(e + " ");
            });
            System.out.println();
        });
    }

    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            int[] K = new int[k];
            for (int i = 0; i < k; i++) {
                K[i] = i + 1;
            }

            int total = combination(n, k);
            List<List<Integer>> r = new ArrayList<>(total);
            r.add(generate(K));
            for (int i = 1; i < total; i++) {
                plusOne(K, n);
                r.add(generate(K));
            }
            return r;
        }

        private int combination(int n, int k) {
            long dividend = 1;
            for (long i = n - k + 1; i <= n; i++) {
                dividend *= i;
            }

            long divisor = 1;
            for (long i = 2; i <= k; i++) {
                divisor *= i;
            }

            return (int)(dividend / divisor);
        }

        private List<Integer> generate(int[] arr) {
            List<Integer> r = new LinkedList<>();
            for (int i = 0; i < arr.length; i++) {
                r.add(arr[i]);
            }
            return r;
        }

        public void plusOne(int[] arr, int n) {
            int i = arr.length - 1;
            while (i >= 0) {
                int end = n - arr.length + i + 1;
                if (arr[i] == end) {
                    i--;
                } else {
                    arr[i]++;
                    break;
                }
            }

            if (i < 0) {
                return;
            }

            i++;
            while (i < arr.length) {
                arr[i] = arr[i - 1] + 1;
                i++;
            }
        }
    }
}
