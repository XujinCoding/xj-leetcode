package com.xj.leetcode.leetcode.editor.cn;

import java.util.*;

import com.xj.leetcode.common.*;

public class SubstringWithConcatenationOfAllWords {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> res = new ArrayList<Integer>();
            int m = words.length, n = words[0].length(), ls = s.length();
            for (int i = 0; i < n; i++) {
                if (i + m * n > ls) {
                    break;
                }
                Map<String, Integer> differ = new HashMap<String, Integer>();
                for (int j = 0; j < m; j++) {
                    String word = s.substring(i + j * n, i + (j + 1) * n);
                    differ.put(word, differ.getOrDefault(word, 0) + 1);
                }
                for (String word : words) {
                    differ.put(word, differ.getOrDefault(word, 0) - 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }
                }
                for (int start = i; start < ls - m * n + 1; start += n) {
                    if (start != i) {
                        String word = s.substring(start + (m - 1) * n, start + m * n);
                        differ.put(word, differ.getOrDefault(word, 0) + 1);
                        if (differ.get(word) == 0) {
                            differ.remove(word);
                        }
                        word = s.substring(start - n, start);
                        differ.put(word, differ.getOrDefault(word, 0) - 1);
                        if (differ.get(word) == 0) {
                            differ.remove(word);
                        }
                    }
                    if (differ.isEmpty()) {
                        res.add(start);
                    }
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new SubstringWithConcatenationOfAllWords().new Solution();
        // put your test code here
        System.out.println(solution.findSubstring("abaababbaba", new String[]{"ab", "ba", "ab", "ba"}));

    }

    public List<Integer> findSubstring(String s, String[] words) {
        if (s.isEmpty() || words.length == 0) return Collections.emptyList();
        int wordLength = words[0].length();
        if (s.length() < wordLength * words.length) return Collections.emptyList();

        Map<String, Integer> keyMap = new HashMap<>(words.length);
        for (String word : words) {
            keyMap.put(word, keyMap.getOrDefault(word, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        int left = 0, right = 0;
        while (right + wordLength <= s.length()) {
            //接下来的单词匹配, 滑动右边界窗口扩大
            if (keyMap.containsKey(s.substring(right, right + wordLength)) && keyMap.get(s.substring(right, right + wordLength)) > 0) {
                keyMap.put(s.substring(right, right + wordLength), keyMap.get(s.substring(right, right + wordLength)) - 1);
                right += wordLength;
                // 接下来的单词不存在, 放弃现在的窗口, 从右边界下一个字母开始创建窗口
            } else if (!keyMap.containsKey(s.substring(right, right + wordLength))) {
                left++;
                right = left;
                keyMap = new HashMap<>(words.length);
                for (String word : words) {
                    keyMap.put(word, keyMap.getOrDefault(word, 0) + 1);
                }
                // 接下来的单词已经用完了, 重置窗口
            } else if (keyMap.get(s.substring(right, right + wordLength)) == 0) {
                left++;
                right = left;
                keyMap = new HashMap<>(words.length);
                for (String word : words) {
                    keyMap.put(word, keyMap.getOrDefault(word, 0) + 1);
                }
            }
            //如果全部匹配成功, 则进行记录, 并重置窗口
            if (keyMap.values().stream().allMatch(value -> value == 0)) {
                result.add(left);
                left++;
                right = left;
                keyMap = new HashMap<>(words.length);
                for (String word : words) {
                    keyMap.put(word, keyMap.getOrDefault(word, 0) + 1);
                }
            }
        }
        return result;
    }
}