package algorithms.before20200830;


/**
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseLinkedList {


    public ListNode reverseList(ListNode head) {

        ListNode curr = head;
        ListNode pre = null;
        while (curr != null) {

            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }

        return pre;

    }


    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();

        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        System.out.println(list.reverseList(node));
    }
}
