//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
// 
// 
//输入：board = [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word = 
//"ABCCED"
//输出：true
//
//
// 示例 2：
//
//
//输入：board = [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word =
//"SEE"
//输出：true
//
//
// 示例 3：
//
//
//输入：board = [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word =
//"ABCB"
//输出：false
//
//
//
//
// 提示：
//
//
// m == board.length
// n = board[i].length
// 1 <= m, n <= 6
// 1 <= word.length <= 15
// board 和 word 仅由大小写英文字母组成
//
//
//
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？
//
// Related Topics 深度优先搜索 数组 字符串 回溯 矩阵 👍 2058 👎 0


package com.xj.leetcode.editor.cn;

import com.xj.leetcode.common.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 单词搜索
 *
 * @author XuJ
 * @date 2025-09-08 11:38:30
 */
class P79_WordSearch {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P79_WordSearch().new Solution();
        System.out.println(solution.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCESEEEFS"));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean exist(char[][] board, String word) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == word.charAt(0)) {
                        // 需要记录走过的路径点
                        boolean dfs = dfs(board, word.toCharArray(), 0, i, j);
                        if (dfs) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        public boolean dfs(char[][] board, char[] word, int index, int i, int j) {
            if (index >= word.length) {
                return true;
            }
            if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || word[index] != board[i][j]) {
                // 已经超出边界数据错误
                return false;
            }
            //设置一个不可能相同的值, 来完成路径不能重复走
            board[i][j] = '\0';
            boolean up = dfs(board, word, index + 1, i - 1, j);
            boolean down = dfs(board, word, index + 1, i + 1, j);
            boolean left = dfs(board, word, index + 1, i, j - 1);
            boolean right = dfs(board, word, index + 1, i, j + 1);
            board[i][j] = word[index];
            return up || down || left || right;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)


    class SolutionTest {
        public boolean exist(char[][] board, String word) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == word.charAt(0)) {
                        // 需要记录走过的路径点
                        boolean dfs = dfs(board, word, 0, i, j, new ArrayList<>());
                        if (dfs) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        public boolean dfs(char[][] board, String word, int index, int i, int j, List<String> routeList) {
            if (index >= word.length()) {
                return true;
            }
            if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
                // 已经超出边界数据错误
                return false;
            }
            if (word.charAt(index) == board[i][j] && !routeList.contains(i + "," + j)) {
                routeList.add(i + "," + j);
                boolean up = dfs(board, word, index + 1, i - 1, j, routeList);
                boolean down = dfs(board, word, index + 1, i + 1, j, routeList);
                boolean left = dfs(board, word, index + 1, i, j - 1, routeList);
                boolean right = dfs(board, word, index + 1, i, j + 1, routeList);
                routeList.remove(routeList.size() - 1);
                return up || down || left || right;
            } else {
                return false;
            }
        }
    }
}
