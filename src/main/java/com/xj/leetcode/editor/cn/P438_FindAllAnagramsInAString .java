//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
//
//
//
// 示例 1:
//
//
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
//
//
// 示例 2:
//
//
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
//
//
//
//
// 提示:
//
//
// 1 <= s.length, p.length <= 3 * 10⁴
// s 和 p 仅包含小写字母
//
//
// Related Topics 哈希表 字符串 滑动窗口 👍 1772 👎 0


package com.xj.leetcode.editor.cn;

import com.xj.leetcode.common.*;

import java.util.*;

/**
 * 找到字符串中所有字母异位词
 *
 * @author XuJ
 * @date 2025-10-13 11:22:02
 */
class P438_FindAllAnagramsInAString {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P438_FindAllAnagramsInAString().new Solution();
        System.out.println(solution.findAnagrams("cbaebabacd", "abc"));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            int sLen = s.length(), pLen = p.length();

            if (sLen < pLen) {
                return new ArrayList<Integer>();
            }

            List<Integer> ans = new ArrayList<Integer>();
            int[] sCount = new int[26];
            int[] pCount = new int[26];
            for (int i = 0; i < pLen; ++i) {
                ++sCount[s.charAt(i) - 'a'];
                ++pCount[p.charAt(i) - 'a'];
            }

            if (Arrays.equals(sCount, pCount)) {
                ans.add(0);
            }

            for (int i = 0; i < sLen - pLen; ++i) {
                --sCount[s.charAt(i) - 'a'];
                ++sCount[s.charAt(i + pLen) - 'a'];

                if (Arrays.equals(sCount, pCount)) {
                    ans.add(i + 1);
                }
            }

            return ans;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)
class SolutionTest {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            countMap.put(p.charAt(i), countMap.getOrDefault(p.charAt(i), 0) + 1);
        }
        int left = 0, right = 0;
        while (left < s.length() && right < s.length()) {
            if (p.length() == right - left) {
                res.add(left);
            }
            if (countMap.containsKey(s.charAt(right))) {
                Integer i = countMap.get(s.charAt(right));
                if (i > 0) {
                    countMap.put(s.charAt(right), i - 1);
                    right++;
                } else {
                    if (countMap.containsKey(s.charAt(left))) {
                        countMap.put(s.charAt(left), countMap.get(s.charAt(left)) + 1);
                    }
                    left++;
                }
            } else {
                for (int i = left; i < right; i++) {
                    if (countMap.containsKey(s.charAt(i))) {
                        countMap.put(s.charAt(i), countMap.get(s.charAt(i)) + 1);
                    }
                    left++;
                }
                right++;
                left++;
            }

        }
        if (p.length() == right - left) {
            res.add(left);
        }
        return res;

    }
}


}