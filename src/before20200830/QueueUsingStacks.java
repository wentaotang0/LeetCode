package before20200830;


import java.util.Stack;

/**
 * 使用栈实现队列的下列操作：
 * <p>
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 * 示例:
 * <p>
 * MyQueue queue = new MyQueue();
 * <p>
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // 返回 1
 * queue.pop();   // 返回 1
 * queue.empty(); // 返回 false
 * 说明:
 * <p>
 * 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-queue-using-stacks
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class QueueUsingStacks {


    private Stack<Integer> s1;
    private Stack<Integer> s2;
    private int front;


    /**
     * Initialize your data structure here.
     */
    public QueueUsingStacks() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {

        if (s1.isEmpty()) front = x;
        while (!s1.isEmpty()) {//s1不为空时，将s1所有元素放入s2
            s2.push(s1.pop());
        }
        s2.push(x);//s2中放入x
        while (!s2.isEmpty()) {//s2不为空，将s2的所有元素放入s1
            s1.push(s2.pop());
        }
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        Integer pop = s1.pop();
        if (!s1.isEmpty()) front = s1.peek();
        return pop;
    }

    /**
     * Get the front element.
     */
    public int peek() {

        return front;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return s1.isEmpty();
    }


    public static void main(String[] args) {
        QueueUsingStacks usingStacks = new QueueUsingStacks();
        usingStacks.push(1);
        usingStacks.push(2);
        usingStacks.push(3);

        System.out.println(usingStacks.pop());
        System.out.println("---"+usingStacks.peek());
        System.out.println(usingStacks.pop());

        System.out.println(usingStacks.pop());
    }
}
