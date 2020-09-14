package algorithms.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * @author twt
 * @description 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 5000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/09/13
 */
public class ReverseList {


    /**
     * 原地反转
     * 使用两个指针
     *
     * @param head 链表头
     * @return
     */
   /* public ListNode reverseList(ListNode head) {

        ListNode p1 = null;
        ListNode p2 = head.next;
        ListNode temp = null;

        while (p2 != null) {
            temp = p2.next;
            p2.next = p1;

            p1 = p2;
            p2 = temp.next;
        }
        return p2;
    }*/


    /**
     * o(n)空间复杂度
     *
     * @param head 链表头
     * @return
     */
    public ListNode reverseList(ListNode head) {

        ArrayList<Integer> nodes = new ArrayList<>();
        while (head != null) {
            nodes.add(head.val);
            head = head.next;
        }

        if (nodes.size() == 0) return null;
        ListNode pre = new ListNode(nodes.get(nodes.size() - 1));
        ListNode ans = pre;
        for (int i = nodes.size() - 2; i >= 0; i--) {
            ListNode cur = new ListNode(nodes.get(i));
            pre.next = cur;
            pre = pre.next;
        }
        return ans;
    }


    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);

        n1.next = n2;
        n2.next = n3;

        new ReverseList().reverseList(n1);


        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        List l2 = list;
        l2 = null;
        System.out.println(list);
    }
}
