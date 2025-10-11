//给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。 
//
// 回文字符串 是正着读和倒过来读一样的字符串。 
//
// 子字符串 是字符串中的由连续字符组成的一个序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 
//输入：s = "aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由小写英文字母组成 
// 
//
// Related Topics 双指针 字符串 动态规划 👍 1466 👎 0


package com.xj.leetcode.editor.cn;

import com.xj.leetcode.common.*;

/**
 * 回文子串
 *
 * @author XuJ
 * @date 2025-10-11 10:33:24
 */
class P647_PalindromicSubstrings {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P647_PalindromicSubstrings().new Solution();
        solution.countSubstrings("aaa");
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSubstrings(String s) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                int left = i - 1;
                int right = i + 1;
                while (left >= 0 && right < s.length()) {
                    if (s.charAt(left) == s.charAt(right)) {
                        left--;
                        right++;
                        count++;
                    } else {
                        break;
                    }
                }
            }
            for (int i = 0; i < s.length(); i++) {
                int left = i - 1;
                int right = i;
                while (left >= 0 && right < s.length()) {
                    if (s.charAt(left) == s.charAt(right)) {
                        left--;
                        right++;
                        count++;
                    } else {
                        break;
                    }
                }
            }
            return count + s.length();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
