package before20200830;


/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

 示例：

 输入：1->2->4, 1->3->4
 输出：1->1->2->3->4->4

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode temp = new ListNode(0);
        ListNode head = temp;
        while (l1!=null && l2!=null){
            int l1Val = l1.val;
            int l2Val = l2.val;
            if (l1Val<l2Val){
                head.next = new ListNode(l1Val);
                l1 = l1.next;
            }else {
                head.next = new ListNode(l2Val);
                l2 = l2.next;
            }
            head = head.next;
        }

        if (l1!=null) head.next = l1;
        if (l2!=null) head.next = l2;
        return temp.next;

    }


    public static void main(String[] args) {
        MergeTwoSortedLists lists = new MergeTwoSortedLists();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        System.out.println(lists.mergeTwoLists(l1, l2));
    }
}
