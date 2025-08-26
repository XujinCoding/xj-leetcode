package com.xj.leetcode.leetcode.editor.cn;

import java.util.*;

import com.xj.leetcode.common.*;

public class MedianOfTwoSortedArrays {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if (nums1.length == 0 && nums2.length == 0) {
                return 0.0;
            }
            List<Integer> list = new ArrayList<>();
            boolean twoNum = false;
            int mid;
            if ((nums1.length + nums2.length) % 2 == 0) {
                twoNum = true;
            }
            // 找到第几位是中位数(下标)
            mid = (nums1.length + nums2.length) / 2;
            int nums1Index = 0;
            int nums2Index = 0;
            while (nums1Index < nums1.length && nums2Index < nums2.length) {
                if (nums1[nums1Index] < nums2[nums2Index]) {
                    list.add(nums1[nums1Index]);
                    nums1Index++;
                } else {
                    list.add(nums2[nums2Index]);
                    nums2Index++;
                }
            }
            if (nums1Index == nums1.length) {
                fillList(list, nums2, nums2Index);
            } else {
                fillList(list, nums1, nums1Index);
            }
            if (twoNum) {
                return (list.get(mid) + list.get(mid - 1)) / 2.0;
            } else {
                return list.get(mid);
            }


        }

        private void fillList(List<Integer> list, int[] nums1, int index) {
            for (int i = index; i < nums1.length; i++) {
                list.add(nums1[i]);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    // 正解为大顶堆
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
        // put your test code here

        System.out.println(solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }

    /**
     * 大顶堆解法
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return 0.0;
    }


}