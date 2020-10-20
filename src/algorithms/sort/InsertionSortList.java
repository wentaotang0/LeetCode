package algorithms.sort;

import algorithms.linkedlist.ListNode;

/**
 * @author twt
 * @description 对链表进行插入排序。
 * <p>
 * <p>
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 * <p>
 *  
 * <p>
 * 插入排序算法：
 * <p>
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 * <p>
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insertion-sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/10/18
 */
public class InsertionSortList {


    /**
     * 插入排序
     *
     * @param head
     * @return
     */
    /*public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            //已排序区间从头开始比较
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            //将cur插入pre和pre.next之间
            cur.next = pre.next;
            pre.next = cur;
            //pre每次从头开始
            pre = dummy;
            cur = next;
        }
        return dummy.next;
    }*/
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode pre = dummy;
        //指向已排序最大的元素
        ListNode tail = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val > tail.val) {
                tail.next = cur;
                tail = cur;
                cur = cur.next;
            } else {
                ListNode temp = cur.next;
                //防止成环。因为当cur=pre.next时，pre.next=tail，tail.next=pre.next.next=cur。
                tail.next = temp;
                while (pre.next != null && pre.next.val < cur.val) {
                    pre = pre.next;
                }
                cur.next = pre.next;
                pre.next = cur;
                pre = dummy;
                cur = temp;
            }
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(3);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        new InsertionSortList().insertionSortList(n1);
    }
}
