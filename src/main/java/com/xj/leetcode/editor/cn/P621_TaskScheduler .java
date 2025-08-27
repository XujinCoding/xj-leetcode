//给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表，用字母 A 到 Z 表示，以及一个冷却时间 n。每个周期或时间间隔允许完成一项任务。任务
//可以按任何顺序完成，但有一个限制：两个 相同种类 的任务之间必须有长度为 n 的冷却时间。 
//
// 返回完成所有任务所需要的 最短时间间隔 。 
//
// 
//
// 示例 1： 
//
// 
// 输入：tasks = ['A','A','A','B','B','B'], n = 2
// 
//
// 
// 输出：8
// 
//
// 
// 解释：
// 
//
// 
// 在完成任务 A 之后，你必须等待两个间隔。对任务 B 来说也是一样。在第 3 个间隔，A 和 B 都不能完成，所以你需要待命。在第 4 个间隔，由于已经经
//过了 2 个间隔，你可以再次执行 A 任务。
// 
//
// 
// 
// 
//
// 示例 2： 
//
// 
// 输入：tasks = ['A','C','A','B','D','B'], n = 1 
// 
//
// 输出：6 
//
// 解释：一种可能的序列是：A -> B -> C -> D -> A -> B。 
//
// 由于冷却间隔为 1，你可以在完成另一个任务后重复执行这个任务。 
//
// 示例 3： 
//
// 
// 输入：tasks = ['A','A','A','B','B','B'], n = 3
// 
//
// 
// 输出：10
// 
//
// 
// 解释：一种可能的序列为：A -> B -> idle -> idle -> A -> B -> idle -> idle -> A -> B。
// 
//
// 
// 只有两种任务类型，A 和 B，需要被 3 个间隔分割。这导致重复执行这些任务的间隔当中有两次待命状态。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= tasks.length <= 10⁴ 
// tasks[i] 是大写英文字母 
// 0 <= n <= 100 
// 
//
// Related Topics 贪心 数组 哈希表 计数 排序 堆（优先队列） 👍 1333 👎 0


package com.xj.leetcode.editor.cn;

import com.xj.leetcode.common.*;

import java.util.*;

/**
 * 任务调度器
 *
 * @author XuJ
 * @date 2025-08-27 10:44:48
 */
class P621_TaskScheduler {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P621_TaskScheduler().new Solution();
        System.out.println(solution.leastInterval(new char[]{'B', 'C', 'D', 'A', 'A', 'A', 'A', 'G'}, 1));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int leastInterval(char[] tasks, int n) {
            int len = tasks.length;
            if (n == 0 || len == 1) {
                return len;
            }
            int[] cnt = new int[26];
            for (char task : tasks) {
                cnt[task - 'A']++;
            }
            int count = 0;
            int max = 0;
            for (int i = 0; i < 26; i++) {
                if (cnt[i] > max) {
                    max = cnt[i];
                    count = 1;
                } else if (cnt[i] == max) {
                    count++;
                }
            }
            return Math.max(len, (max - 1) * (n + 1) + count);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
