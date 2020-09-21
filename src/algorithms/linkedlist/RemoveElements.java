package algorithms.linkedlist;

/**
 * @author twt
 * @description 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 * @date 2020/09/20
 */
public class RemoveElements {


    /**
     * 使用哨兵，来使头节点为待删除节点的情况变为待删除节点为中间节点，使用前后指针删除
     * 也可以while循环删除头节点后，使用前后指针删除
     *
     * @param head
     * @param val
     * @return
     */
    /*public ListNode removeElements(ListNode head, int val) {

        if (head == null) return null;
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        ListNode pre = sentinel;
        ListNode cur = head;

        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }

        return sentinel.next;
    }*/

    /**
     * 递归删除
     * 类似把每个节点放入栈，弹栈的时候判断头节点是否需要删除，需要则返回head.next，否则返回head，返回后的节点需要挂在后面一个需要弹栈的节点后面。
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;

        head.next = removeElements(head.next, val);
        if (head.val == val) {
            return head.next;
        } else {
            return head;
        }
    }


    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;

        System.out.println(new RemoveElements().removeElements(n1, 2));
    }
}
