package algorithms.linkedlist;

/**
 * @author twt
 * @description 编写一个函数，检查输入的链表是否是回文的。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入： 1->2
 * 输出： false
 * 示例 2：
 * <p>
 * 输入： 1->2->2->1
 * 输出： true
 *  
 * <p>
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/09/20
 */
public class IsPalindrome {
    /**
     * 栈
     *
     * @param head
     * @return
     */
    /*public boolean isPalindrome(ListNode head) {

        Stack<Integer> stack = new Stack<>();

        ListNode comp = head;
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        int l = stack.size();
        for (int i = 0; i < l; i++) {
            if (!stack.pop().equals(comp.val)) {
                return false;
            }
            comp = comp.next;
        }
        return true;
    }*/

    /**
     * 1.快慢指针找到中间节点
     * 2.反转中间节点后面的链表
     * 3.比较反转后的链表和原链表
     *
     * @param head
     * @return
     */
    /*public boolean isPalindrome(ListNode head) {
        ListNode middleNode = findMiddleNode(head);
        ListNode reverseNode = reverseNode(middleNode);

        ListNode cur = head;
        while (reverseNode != null) {
            if (reverseNode.val != cur.val) {
                return false;
            }
            cur = cur.next;
            reverseNode = reverseNode.next;
        }
        return true;

    }

    private ListNode findMiddleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseNode(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }*/


    /**
     * 使用快慢指针寻找中间节点的时候反转链表前半部分，比较反转后的链表和链表的后半部分
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;

        while (fast != null && fast.next != null) {
            ListNode cur = slow;
            slow = slow.next;
            fast = fast.next.next;
            cur.next = pre;
            pre = cur;
        }

        if (fast!= null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (slow.val != pre.val) {
                return false;
            }
            slow = slow.next;
            pre = pre.next;
        }
        return true;

    }


    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        new IsPalindrome().isPalindrome(n1);
    }
}
