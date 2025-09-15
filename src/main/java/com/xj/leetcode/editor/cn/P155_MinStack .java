//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 实现 MinStack 类: 
//
// 
// MinStack() 初始化堆栈对象。 
// void push(int val) 将元素val推入堆栈。 
// void pop() 删除堆栈顶部的元素。 
// int top() 获取堆栈顶部的元素。 
// int getMin() 获取堆栈中的最小元素。 
// 
//
// 
//
// 示例 1: 
//
// 
//输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= val <= 2³¹ - 1 
// pop、top 和 getMin 操作总是在 非空栈 上调用 
// push, pop, top, and getMin最多被调用 3 * 10⁴ 次 
// 
//
// Related Topics 栈 设计 👍 1979 👎 0


package com.xj.leetcode.editor.cn;

import com.xj.leetcode.common.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 最小栈
 *
 * @author XuJ
 * @date 2025-09-15 09:40:30
 */
class P155_MinStack {
    public static void main(String[] args) {
        //测试代码
        MinStack solution = new P155_MinStack().new MinStack();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {
        private Stack<Integer> stack;
        private Stack<Integer> min_stack;
        public MinStack() {
            stack = new Stack<>();
            min_stack = new Stack<>();
        }
        public void push(int x) {
            stack.push(x);
            if(min_stack.isEmpty() || x <= min_stack.peek())
                min_stack.push(x);
        }
        public void pop() {
            if(stack.pop().equals(min_stack.peek()))
                min_stack.pop();
        }
        public int top() {
            return stack.peek();
        }
        public int getMin() {
            return min_stack.peek();
        }
    }


    /**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)
class MinStackTest {

    Stack<Integer> stack;
    int minVal;
    Map<Integer,Integer> numMap= new HashMap<>();

    public MinStackTest() {
        stack = new Stack<>();
        minVal = Integer.MAX_VALUE;
    }

    public void push(int val) {
        numMap.put(val,numMap.getOrDefault(val,0)+1);
        minVal = Math.min(minVal,val);
        stack.push(val);
    }

    public void pop() {
        Integer pop = stack.pop();
        Integer i = numMap.get(pop);
        if (i == 1){
            numMap.remove(pop);
            if (minVal == pop){
                minVal = reCalMinVal();
            }
        }else {
            numMap.put(pop,numMap.get(pop)-1);
        }
    }
    public int reCalMinVal(){
        int min = Integer.MAX_VALUE;
        for (Integer i : numMap.keySet()) {
            min = Math.min(min,i);
        }
        return min;
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minVal;
    }
}
}
