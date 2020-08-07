package com.wei.leetcode.problem;

/**
 * @author wei wang
 * @date 2020/08/06
 */
public class P56MergeIntervals {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        // int[][] intervals = {{1, 4}, {4, 5}};
        // int[][] intervals = {{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}};
        // int[][] intervals = {{5, 7}, {5, 5}, {1, 1}, {0, 0}, {3, 3}, {4, 5}, {1, 1}, {3, 4}};
        int[][] intervals = {{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}};
        // int[][] intervals = {{362, 367}, {314, 315}, {133, 138}, {434, 443}, {202, 203}, {144, 145}, {229, 235},
        // {205, 212}, {314, 323}, {128, 129}, {413, 414}, {342, 345}, {43, 49}, {333, 342}, {173, 178}, {386, 391},
        // {131, 133}, {157, 163}, {187, 190}, {186, 186}, {17, 19}, {63, 69}, {70, 79}, {386, 391}, {98, 102},
        // {236, 239}, {195, 195}, {338, 338}, {169, 170}, {151, 153}, {409, 416}, {377, 377}, {90, 96}, {156, 165},
        // {182, 186}, {371, 372}, {228, 233}, {297, 306}, {56, 61}, {184, 190}, {401, 403}, {221, 228}, {203, 212},
        // {39, 43}, {83, 84}, {66, 68}, {80, 83}, {32, 32}, {182, 182}, {300, 306}, {235, 238}, {267, 272},
        // {458, 464}, {114, 120}, {452, 452}, {372, 375}, {275, 280}, {302, 302}, {5, 9}, {54, 62}, {237, 237},
        // {432, 439}, {415, 421}, {340, 347}, {356, 358}, {165, 168}, {15, 17}, {259, 265}, {201, 204}, {192, 197},
        // {376, 383}, {210, 211}, {362, 367}, {481, 488}, {59, 64}, {307, 315}, {155, 164}, {465, 467}, {55, 60},
        // {20, 24}, {297, 304}, {207, 210}, {322, 328}, {139, 142}, {192, 195}, {28, 36}, {100, 108}, {71, 76},
        // {103, 105}, {34, 38}, {439, 441}, {162, 168}, {433, 433}, {368, 369}, {137, 137}, {105, 112}, {278, 280},
        // {452, 452}, {131, 132}, {475, 480}, {126, 129}, {95, 104}, {93, 99}, {394, 403}, {70, 78}};
        int[][] r = new P56MergeIntervals().new Solution().merge(intervals);
        for (int i = 0; i < r.length; i++) {
            System.out.println(r[i][0] + ", " + r[i][1]);
        }
    }

    class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals.length <= 1) {
                return intervals;
            }

            ListNode head = new ListNode(intervals[0][0], intervals[0][1], null, null);
            int cnt = 1;

            for (int i = 1; i < intervals.length; i++) {
                ListNode curr = head;
                int begin = intervals[i][0];
                int end = intervals[i][1];
                while (curr != null) {
                    int pos = position(curr, begin, end);
                    if (pos == -1) {
                        if (curr.next == null) {
                            curr.next = new ListNode(begin, end, null, curr);
                            cnt++;
                            break;
                        }
                        curr = curr.next;
                    }

                    if (pos == 0) {
                        curr.begin = (curr.begin < begin) ? curr.begin : begin;
                        curr.end = (curr.end > end) ? curr.end : end;

                        ListNode next = curr.next;
                        while (next != null) {
                            if (next.begin > curr.end) {
                                break;
                            }
                            curr.end = (curr.end > next.end ? curr.end : next.end);
                            curr.next = next.next;
                            next = curr.next;
                            if (next != null) {
                                next.prev = curr;
                            }
                            cnt--;
                        }
                        break;
                    }

                    if (pos == 1) {
                        if (curr.prev == null) {
                            curr = new ListNode(begin, end, curr, null);
                            curr.next.prev = curr;
                            head = curr;
                        } else {
                            ListNode node = new ListNode(begin, end, curr, curr.prev);
                            curr.prev.next = node;
                            curr.prev = node;
                        }
                        cnt++;
                        break;
                    }
                }
            }

            int[][] r = new int[cnt][2];
            ListNode curr = head;
            int i = 0;
            while (curr != null) {
                r[i][0] = curr.begin;
                r[i][1] = curr.end;
                i++;
                curr = curr.next;
            }
            return r;
        }

        // -1: node.end < (begin, end)
        // 0: overlap
        // 1: (begin, end) < node.begin
        private int position(ListNode node, int begin, int end) {
            if (node.end < begin) {
                return -1;
            }
            if (node.begin > end) {
                return 1;
            }

            return 0;
        }
    }

    class ListNode {
        int begin;
        int end;

        ListNode next;
        ListNode prev;

        public ListNode(int begin, int end, ListNode next, ListNode prev) {
            this.begin = begin;
            this.end = end;
            this.next = next;
            this.prev = prev;
        }
    }
}
