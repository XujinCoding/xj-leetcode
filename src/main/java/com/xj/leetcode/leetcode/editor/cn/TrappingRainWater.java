package com.xj.leetcode.leetcode.editor.cn;

import java.util.*;
import com.xj.leetcode.common.*;

public class TrappingRainWater {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            int left = 0;
            int right = height.length - 1;

            int preSum = 0;
            int sufSum = 0;
            int sum = 0;
            while (left <= right){
                preSum = Math.max(preSum, height[left]);
                sufSum = Math.max(sufSum, height[right]);
                if (preSum < sufSum){
                    sum += (preSum - height[left]);
                    left++;
                }else{
                    sum += (sufSum - height[right]);
                    right--;
                }
            }
            return sum;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new TrappingRainWater().new Solution();
        // put your test code here
        
    }
}