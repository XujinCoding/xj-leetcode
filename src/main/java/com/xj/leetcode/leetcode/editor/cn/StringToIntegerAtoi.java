package com.xj.leetcode.leetcode.editor.cn;

import java.util.*;

import com.xj.leetcode.common.*;

public class StringToIntegerAtoi {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int myAtoi(String s) {
            int n = s.length();
            int i = 0;
            int sign = 1;
            long res = 0;
            while (i < n && s.charAt(i) == ' ') {
                i++;
            }
            if (i == n) {
                return 0;
            }
            if (s.charAt(i) == '-') {
                sign = -1;
                i++;
            } else if (s.charAt(i) == '+') {
                i++;
            }
            if (i == n) {
                return 0;
            }
            while (i < n && '0' <= s.charAt(i) && s.charAt(i) <= '9') {
                res = res * 10 + s.charAt(i) - '0';
                if (res > Integer.MAX_VALUE) {
                    break;
                }
                i++;
            }
            if ((int) res != res) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            return (int) res * sign;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new StringToIntegerAtoi().new Solution();
        // put your test code here
        System.out.println(solution.myAtoi("+-12"));

    }
}