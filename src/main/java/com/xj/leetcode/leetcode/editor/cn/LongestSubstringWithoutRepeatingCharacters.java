package com.xj.leetcode.leetcode.editor.cn;

import java.util.*;

import com.xj.leetcode.common.*;

public class LongestSubstringWithoutRepeatingCharacters {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Set<Character> disChar = new HashSet<>();
            int left = 0, right = 0;
            int maxWindows = 0;
            while (right < s.length()) {
                if(!disChar.contains(s.charAt(right))) {
                    disChar.add(s.charAt(right));
                    right++;
                }else {
                    disChar.remove(s.charAt(left));
                    left++;
                }
                maxWindows=Math.max(maxWindows, right - left);
            }
            return maxWindows;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        // put your test code here
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
    }
}