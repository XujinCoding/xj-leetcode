package com.xj.leetcode.leetcode.editor.cn;

import java.util.*;
import com.xj.leetcode.common.*;

public class SearchInRotatedSortedArray {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                }
                if (nums[left] == target) {
                    return left;
                }
                if (nums[right] == target) {
                    return right;
                }
                if (left == right){
                    return -1;
                }
                boolean inLeftOrder = nums[mid] > target && nums[left] < target;
                boolean inRightOrder = nums[mid] < target &&  nums[right] > target;
                if(nums[mid] > nums[left] && inLeftOrder) {
                    right = mid -1;
                }else if (nums[mid] > nums[left]){
                    left = mid + 1;
                }else if(nums[mid] < nums[right] && inRightOrder) {
                    left = mid + 1;
                }else if(nums[mid] < nums[right]) {
                    right = mid - 1;
                }else{
                    left ++;
                }
            }
            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArray().new Solution();
        // put your test code here
        System.out.println(solution.search(new int[]{8,1,2,3,4,5,6,7}, 6));

    }
}