//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
//
// Related Topics 数组 排序 👍 2625 👎 0


package com.xj.leetcode.editor.cn;
import com.xj.leetcode.common.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 合并区间
 * @author XuJ
 * @date 2025-08-28 11:36:34
 */
class P56_MergeIntervals{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P56_MergeIntervals().new Solution();
          solution.merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();

        //先按照start排序
        Arrays.sort(intervals, Comparator.comparing((a) -> a[0]));
        //如果下一个的start<=上一个的end则可以合并
        for (int i = 0; i < intervals.length; i++) {
            if (res.isEmpty()){
                res.add(intervals[i]);
                continue;
            }
            int preLast = res.get(res.size() - 1)[1];
            if (intervals[i][0] <= preLast){
                res.get(res.size()-1)[1] =  Math.max(intervals[i][1], preLast);
            }else{
                res.add(intervals[i]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
