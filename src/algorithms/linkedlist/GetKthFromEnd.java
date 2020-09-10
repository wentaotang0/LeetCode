package algorithms.linkedlist;

import java.util.Stack;

/**
 * @author twt
 * @description 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * <p>
 * 返回链表 4->5.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/09/10
 */
public class GetKthFromEnd {

    /**
     * 先遍历得到链表的长度n，再遍历到n-k位置
     *
     * @param head
     * @param k
     * @return
     */
   /* public ListNode getKthFromEnd(ListNode head, int k) {


        ListNode dup = head;
        int n = 0;
        while (dup != null) {
            n++;
            dup = dup.next;
        }

        for (int i = 0; i < n - k; i++) {
            head = head.next;
        }

        return head;
    }*/

    /**
     * 双指针，指针只需要往前走n-k个位置就可以到指定位置。
     * 所以设置两个指针p1、p2，p1先走k步，接下来p1和p2一起走，直到p1走到终点下一位，p2的位置则为指定位置，此时p2走过n-k
     *
     * @param head
     * @param k
     * @return
     */
    /*public ListNode getKthFromEnd(ListNode head, int k) {

        ListNode former = head, later = head;

        while (k > 0) {
            former = former.next;
            k--;
        }

        while (former != null) {
            former = former.next;
            later = later.next;
        }

        return later;

    }*/

    private int count = 0;

    /**
     * 递归，每遍历一个节点，进行一次压栈，当遍历完后开始弹栈，弹到第k个位置即为倒数第k个节点
     * Stack或者Deque实现
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
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

        return ans;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        GetKthFromEnd kth = new GetKthFromEnd();
        kth.getKthFromEnd(l1, 2);
    }
}
