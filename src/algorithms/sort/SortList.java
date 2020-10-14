package algorithms.sort;

import algorithms.linkedlist.ListNode;

/**
 * @Description 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 * <p>
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 * 通过次数96,332提交次数143,469
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author twt
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/10/13
 */
public class SortList {

    /**
     * 将链表放入数组快速排序，排序后的数组转链表
     *
     * @param head
     * @return
     */
    /*public ListNode sortList(ListNode head) {

        if (head == null) return head;
        List<Integer> list = new ArrayList<>();
        while (head!= null) {
            list.add(head.val);
            head = head.next;
        }
        Collections.sort(list);
        ListNode ans = new ListNode(list.get(0));
        ListNode temp = ans;
        for (int i = 1; i < list.size(); i++) {
            temp.next = new ListNode(list.get(i));
            temp = temp.next;
        }
        return ans;
    }*/

    /**
     * 归并排序
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode q = slow.next;
        //从中间截断指针
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(q);
        //哨兵
        ListNode sentry = new ListNode(0);
        ListNode ans = sentry;
        while (left != null && right != null) {
            if (left.val < right.val) {
                sentry.next = left;
                left = left.next;
            } else {
                sentry.next = right;
                right = right.next;
            }
            sentry = sentry.next;
        }
        sentry.next = left != null ? left : right;
        return ans.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(6);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        new SortList().sortList(head);
    }
}
