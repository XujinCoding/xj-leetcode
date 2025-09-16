//Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补全和拼
//写检查。 
//
// 请你实现 Trie 类： 
//
// 
// Trie() 初始化前缀树对象。 
// void insert(String word) 向前缀树中插入字符串 word 。 
// boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 
//false 。 
// boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否
//则，返回 false 。 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
//[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
//输出
//[null, null, true, false, true, null, true]
//
//解释
//Trie trie = new Trie();
//trie.insert("apple");
//trie.search("apple");   // 返回 True
//trie.search("app");     // 返回 False
//trie.startsWith("app"); // 返回 True
//trie.insert("app");
//trie.search("app");     // 返回 True
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length, prefix.length <= 2000 
// word 和 prefix 仅由小写英文字母组成 
// insert、search 和 startsWith 调用次数 总计 不超过 3 * 10⁴ 次 
// 
//
// Related Topics 设计 字典树 哈希表 字符串 👍 1851 👎 0


package com.xj.leetcode.editor.cn;

import com.xj.leetcode.common.*;

import java.util.*;

/**
 * 实现 Trie (前缀树)
 *
 * @author XuJ
 * @date 2025-09-16 09:45:06
 */
class P208_ImplementTriePrefixTree {
    public static void main(String[] args) {
        //测试代码
        Trie trie = new P208_ImplementTriePrefixTree().new Trie();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Trie {
        private class Node {
            Node[] son = new Node[26];
            boolean end = false;
        }

        private final Node root = new Node();

        public void insert(String word) {
            Node cur = root;
            for (char c : word.toCharArray()) {
                c -= 'a';
                if (cur.son[c] == null) { // 无路可走？
                    cur.son[c] = new Node(); // new 出来！
                }
                cur = cur.son[c];
            }
            cur.end = true;
        }

        public boolean search(String word) {
            return find(word) == 2;
        }

        public boolean startsWith(String prefix) {
            return find(prefix) != 0;
        }

        private int find(String word) {
            Node cur = root;
            for (char c : word.toCharArray()) {
                c -= 'a';
                if (cur.son[c] == null) { // 道不同，不相为谋
                    return 0;
                }
                cur = cur.son[c];
            }
            // 走过同样的路（2=完全匹配，1=前缀匹配）
            return cur.end ? 2 : 1;
        }
    }


    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */
//leetcode submit region end(Prohibit modification and deletion)

    class TrieTest {

        Set<String>[] trie;

        public TrieTest() {
            this.trie = new HashSet[26];
            for (int i = 0; i < 26; i++) {
                trie[i] = new HashSet<>();
            }
        }

        public void insert(String word) {
            Set<String> stringList = trie[word.charAt(0) - 'a'];
            stringList.add(word);
            trie[word.charAt(0) - 'a'] = stringList;
        }

        public boolean search(String word) {
            Set<String> stringList = trie[word.charAt(0) - 'a'];
            return stringList.contains(word);
        }

        public boolean startsWith(String prefix) {
            Set<String> stringList = trie[prefix.charAt(0) - 'a'];
            return stringList.stream().anyMatch(s -> s.startsWith(prefix));
        }
    }

}
