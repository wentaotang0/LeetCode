package before20200830;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class ListNode {

    int val;
    ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {

        ListNode head = this;
        StringBuilder builder = new StringBuilder();
        while (head != null) {

            builder.append(head.val + " ");
            head = head.next;
        }
        return builder.toString();

    }
}
