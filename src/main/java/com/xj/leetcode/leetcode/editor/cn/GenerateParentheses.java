package com.xj.leetcode.leetcode.editor.cn;

import java.util.*;
import com.xj.leetcode.common.*;

public class GenerateParentheses {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            if (n == 0){
                return new ArrayList<>();
            }
            List<String> res = new ArrayList<>();
            String track = "";
            backTrack(n,n,track,res);
            return res;
        }
        void backTrack(int left, int right,String track, List<String> result){
            System.out.println(track);
            if (left > right){
                return;
            }
            if (left < 0 || right < 0){
                return;
            }
            if (left == 0 && right == 0){
                result.add(track);
                return;
            }
            track = track+"(";
            backTrack(left-1,right,track,result);
            track = track.substring(0,track.length()-1);

            track = track+")";
            backTrack(left,right-1,track,result);
            track = track.substring(0,track.length()-1);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        // put your test code here
        System.out.println(solution.generateParenthesis(2));
    }
}