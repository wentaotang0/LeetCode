package algorithms.linkedlist;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author twt
 * @description 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * @date 2020/09/11
 */
public class ReversePrint {

    /**
     * 遍历链表将元素压栈，弹栈将元素存入数据
     * size一定要提出来，遍历过程中size在变化
     * @param head
     * @return
     */
  /*  public int[] reversePrint(ListNode head) {

        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        int size = stack.size();
        int[] ans = new int[size];
        for (int i = 0; i < size; i++) {
            ans[i] = stack.pop();
        }
        return ans;
    }*/


    public int[] reversePrint(ListNode head) {

        Deque<Integer> deque = new ArrayDeque<>();
        while (head != null) {
            deque.addLast(head.val);
            head = head.next;
        }

        int size = deque.size();
        int[] ans = new int[size];
        for (int i = 0; i < size; i++) {
            ans[i] = deque.removeLast();
        }
        return ans;
    }


    public static void main(String[] args) {
        ReversePrint print = new ReversePrint();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(2);

        n1.next=n2;
        n2.next=n3;

        print.reversePrint(n1);
    }
}
