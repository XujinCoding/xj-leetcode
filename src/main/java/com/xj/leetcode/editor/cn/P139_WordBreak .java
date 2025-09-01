//给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。 
//
// 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
// 
//
// 示例 2： 
//
// 
//输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
//     注意，你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 
//输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 300 
// 1 <= wordDict.length <= 1000 
// 1 <= wordDict[i].length <= 20 
// s 和 wordDict[i] 仅由小写英文字母组成 
// wordDict 中的所有字符串 互不相同 
// 
//
// Related Topics 字典树 记忆化搜索 数组 哈希表 字符串 动态规划 👍 2817 👎 0


package com.xj.leetcode.editor.cn;

import com.xj.leetcode.common.*;

import java.util.*;

/**
 * 单词拆分
 *
 * @author XuJ
 * @date 2025-09-01 09:42:22
 */
class P139_WordBreak {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P139_WordBreak().new Solution();
        solution.wordBreak("aaaaaaa", List.of("aaaa", "aaa"));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public boolean wordBreak(String s, List<String> wordDict) {
			Set<String> wordDictSet = new HashSet<>(wordDict);
			boolean[] dp = new boolean[s.length()+1];
			dp[0] = true;
			for (int i = 1; i < s.length()+1; i++) {
				for (int j = 0; j < i; j++) {
					if (dp[j] && wordDictSet.contains(s.substring(j,i))){
						dp[i]=true;
						break;
					}
				}
			}
			return dp[s.length()];
		}
	}

//leetcode submit region end(Prohibit modification and deletion)
class SolutionTest {
	public boolean wordBreak(String s, List<String> wordDict) {
		int maxLen = 0;
		for (String word : wordDict) {
			maxLen = Math.max(maxLen, word.length());
		}
		Set<String> words = new HashSet<>(wordDict);

		int n = s.length();
		int[] memo = new int[n + 1];
		Arrays.fill(memo, -1); // -1 表示没有计算过
		return dfs(n, maxLen, s, words, memo) == 1;
	}

	private int dfs(int i, int maxLen, String s, Set<String> words, int[] memo) {
		if (i == 0) { // 成功拆分！
			return 1;
		}
		if (memo[i] != -1) { // 之前计算过
			return memo[i];
		}
		for (int j = i - 1; j >= Math.max(i - maxLen, 0); j--) {
			if (words.contains(s.substring(j, i)) && dfs(j, maxLen, s, words, memo) == 1) {
				return memo[i] = 1; // 记忆化
			}
		}
		return memo[i] = 0; // 记忆化
	}
}
}
