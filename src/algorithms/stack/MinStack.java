package algorithms.stack;

/**
 * @author twt
 * @description
 * @date 2020/09/27
 */

import java.util.Stack;

/**
 * 额外使用一个栈来存放当前最小值
 */
public class MinStack {


    private Stack<Integer> stack;

    private Stack<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            int min = minStack.peek().intValue() > x ? x : minStack.peek();
            minStack.push(min);
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }
/*
    public int getMin() {
        return minStack.peek();
    }*/

    public int min() {
        return minStack.peek();
    }
}
