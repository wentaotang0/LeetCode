package algorithms.stack;

/**
 * @author twt
 * @description 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 * <p>
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * 提示：
 * <p>
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * <p>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/09/22
 */

import java.util.Stack;

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */

/**
 * 思想是：有两个栈A和B，往A里面添加，从B里面删除。appendTail时，先看B有没有，有的话把B pop到A再添加。deleteHead时先看A有没有，有的话把A pop到B，B再pop一个。
 * 注意一些边缘case
 */
public class CQueue {

    private Stack<Integer> append;
    private Stack<Integer> dele;

    public CQueue() {
        this.append = new Stack<>();
        this.dele = new Stack<>();
    }

    /*public void appendTail(int value) {
        if (!dele.isEmpty()) {
            int num = dele.size();
            for (int i = 0; i < num; i++) {
                append.push(dele.pop());
            }
            append.push(value);
        } else {
            append.push(value);
        }
    }

    public int deleteHead() {
        if (append.isEmpty() && dele.isEmpty()) {
            return -1;
        } else if (!append.isEmpty()) {
            int num = append.size();
            for (int i = 0; i < num; i++) {
                dele.push(append.pop());
            }
        }
        return dele.pop();
    }*/

    /**
     * 优化版1
     *
     * @param value
     */
    public void appendTail(int value) {
        append.push(value);
    }

    public int deleteHead() {
        if (dele.isEmpty()) {
            while (!append.isEmpty()) {
                dele.push(append.pop());
            }
        }


        if (!dele.isEmpty()) {
            return dele.pop();
        } else {
            return -1;
        }
    }
}
