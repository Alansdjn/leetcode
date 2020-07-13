package com.wei.leetcode.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author wei wang
 * @date 2020/07/12
 */
public class P153Sum {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
        List<List<Integer>> result = new P153Sum().new Solution().threeSum(nums);
        result.forEach(item -> {
            item.forEach(ele -> {
                System.out.print(ele + " ");
            });
            System.out.println();
        });
    }

    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            if (nums.length < 3) {
                return Collections.emptyList();
            }

            Arrays.sort(nums);

            if (nums[0] > 0 || nums[nums.length - 1] < 0) {
                return Collections.emptyList();
            }

            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0, j = nums.length - 1; i + 1 < j;) {
                if (nums[i] > 0 || nums[j] < 0) {
                    break;
                }

                int sum = nums[i] + nums[j];
                if (sum < 0) {
                    for (int k = j - 1; k > i; k--) {
                        if (sum + nums[k] < 0) {
                            break;
                        }
                        if (sum + nums[k] == 0) {
                            List<Integer> tmp = assemble(nums[i], nums[k], nums[j]);
                            if (!isRepeat(result, tmp)) {
                                result.add(tmp);
                            }
                            break;
                        }
                        if (sum + nums[k] > 0) {
                            k--;
                        }
                    }
                    i++;
                }
                if (sum >= 0) {
                    for (int k = i + 1; k < j; k++) {
                        if (sum + nums[k] < 0) {
                            k++;
                        }
                        if (sum + nums[k] == 0) {
                            List<Integer> tmp = assemble(nums[i], nums[k], nums[j]);
                            if (!isRepeat(result, tmp)) {
                                result.add(tmp);
                            }
                            break;
                        }
                        if (sum + nums[k] > 0) {
                            break;
                        }
                    }
                    j--;
                }
            }

            return result;
        }

        private List<Integer> assemble(int... a) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < a.length; i++) {
                tmp.add(a[i]);
                System.out.print(a[i] + " ");
            }
            return tmp;
        }

        private boolean isRepeat(List<List<Integer>> result, List<Integer> a) {
            for (int i = 0; i < result.size(); i++) {
                boolean repeat = false;
                List<Integer> currList = result.get(i);
                for (int j = 0; j < currList.size(); j++) {
                    if (currList.get(j) != a.get(j)) {
                        repeat = false;
                        break;
                    }
                    repeat = true;
                }
                if (repeat) {
                    System.out.println("isRepeat");
                    return true;
                }
            }
            System.out.println();
            return false;
        }
    }
}
