package algorithms.stack;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author twt
 * @description 使用队列实现栈的下列操作：
 * <p>
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * 注意:
 * <p>
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-stack-using-queues
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/09/26
 */

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
public class MyStack2 {


    /**
     * 使用一个队列来实现。
     * 弹出元素的时候只要将队列头部的元素（除了最后一个元素外） 重新添加到队列尾部，此时在去弹出元素就是栈的顺序了。
     */
    private Queue<Integer> queue;


    /**
     * Initialize your data structure here.
     */
    public MyStack2() {
        this.queue = new ArrayDeque<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        int size = queue.size();
        while (size > 1) {
            queue.add(queue.poll());
            size--;
        }
        return queue.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        int top = pop();
        queue.add(top);
        return top;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }


    public static void main(String[] args) {
        MyStack2 stack2 = new MyStack2();
        stack2.push(1);
        stack2.push(2);
        System.out.println(stack2.top());
        System.out.println(stack2.pop());
    }

}
