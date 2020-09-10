package algorithms.linkedlist;

import java.util.Stack;

/**
 * @author twt
 * @description 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 * <p>
 * 注意：本题相对原题稍作改动
 * <p>
 * 示例：
 * <p>
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 * 说明：
 * <p>
 * 给定的 k 保证是有效的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/09/10
 */
public class KthToLast {


    /**
     * 双指针
     * @param head
     * @param k
     * @return
     */
    /*public int kthToLast(ListNode head, int k) {

        ListNode former = head, later = head;

        while (k > 0) {
            former = former.next;
            k--;
        }

        while (former != null) {
            former = former.next;
            later = later.next;
        }

        return later.val;
    }*/


    /**
     * 递归，每遍历一个节点，进行一次压栈，当遍历完后开始弹栈，弹到第k个位置即为倒数第k个节点
     * Stack或者Deque实现
     *
     * @param head
     * @param k
     * @return
     */
    public int kthToLast(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();

        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        ListNode ans = null;
        while (0 < k) {
            ans = stack.pop();
            k--;
        }

        return ans.val;
    }
}
