package algorithms.before20200830;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveLinkedListNthFromEnd {

    /**
     * 循环两次
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dumy = new ListNode(0);
        dumy.next = head;

        ListNode temp = head;
        int length = 0;
        while (temp != null) {
            length++;//统计链表的长度
            temp = temp.next;
        }

        if (length > 0) length -= n;//要删除位置的前一个位置
        temp = dumy;//利用哨兵简化实现难度  因为第一个节点和最后一个节点删除操作不一样
        while (length > 0) {
            length--;
            temp = temp.next;//指针指向要删除位置的上一个位置
        }
        temp.next = temp.next.next;//删除倒数第n个节点

        return dumy.next;
    }


    public static void main(String[] args) {
        RemoveLinkedListNthFromEnd nth = new RemoveLinkedListNthFromEnd();
        ListNode node = new ListNode(1);
        node.next = new ListNode(3);
        node.next.next = new ListNode(5);

        System.out.println(nth.removeNthFromEnd(node, 1));
    }
}
