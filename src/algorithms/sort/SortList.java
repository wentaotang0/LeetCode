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
    /*public ListNode sortList(ListNode head) {
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
    }*/
    public ListNode sortList(ListNode head) {
        int length = getLength(head);
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        for (int step = 1; step < length; step *= 2) { //依次将链表分成1块，2块，4块...
            //每次变换步长，pre指针和cur指针都初始化在链表头
            ListNode pre = dummy;
            ListNode cur = dummy.next;
            while (cur != null) {
                ListNode h1 = cur; //第一部分头 （第二次循环之后，cur为剩余部分头，不断往后把链表按照步长step分成一块一块...）
                ListNode h2 = split(h1, step);  //第二部分头
                cur = split(h2, step); //剩余部分的头
                ListNode temp = merge(h1, h2); //将一二部分排序合并
                pre.next = temp; //将前面的部分与排序好的部分连接
                while (pre.next != null) {
                    pre = pre.next; //把pre指针移动到排序好的部分的末尾
                }
            }
        }
        return dummy.next;
    }

    public int getLength(ListNode head) {
        //获取链表长度
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    public ListNode split(ListNode head, int step) {
        //断链操作 返回第二部分链表头
        if (head == null) return null;
        ListNode cur = head;
        for (int i = 1; i < step && cur.next != null; i++) {
            cur = cur.next;
        }
        ListNode right = cur.next;
        cur.next = null; //切断连接
        return right;
    }

    public ListNode merge(ListNode h1, ListNode h2) {
        //合并两个有序链表
        ListNode head = new ListNode(-1);
        ListNode p = head;
        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                p.next = h1;
                h1 = h1.next;
            } else {
                p.next = h2;
                h2 = h2.next;
            }
            p = p.next;
        }
        if (h1 != null) p.next = h1;
        if (h2 != null) p.next = h2;

        return head.next;
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
