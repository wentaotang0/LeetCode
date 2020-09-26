package algorithms.stack;

/**
 * @author twt
 * @description 实现一个MyQueue类，该类用两个栈来实现一个队列。
 * <p>
 * <p>
 * 示例：
 * <p>
 * MyQueue queue = new MyQueue();
 * <p>
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // 返回 1
 * queue.pop();   // 返回 1
 * queue.empty(); // 返回 false
 * <p>
 * 说明：
 * <p>
 * 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-queue-using-stacks-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/09/23
 */

import java.util.Stack;

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
public class MyQueue {

    private Stack<Integer> append;
    private Stack<Integer> dele;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        this.append = new Stack<>();
        this.dele = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        append.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
   /* public int pop() {

        if (dele.isEmpty()) {
            while (!append.isEmpty()) {
                dele.push(append.pop());
            }
        }

        return dele.pop();
    }*/

    /**
     * 复用peek()
     *
     * @return
     */
    public int pop() {
        peek();
        return dele.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (dele.isEmpty()) {
            while (!append.isEmpty()) {
                dele.push(append.pop());
            }
        }

        return dele.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {

        return append.isEmpty() && dele.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        queue.push(3);
        System.out.println(queue.peek());

    }
}
