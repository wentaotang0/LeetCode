package algorithms.linkedlist;

/**
 * @author twt
 * @description 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 * <p>
 * 示例1:
 * <p>
 * 输入：[1, 2, 3, 3, 2, 1]
 * 输出：[1, 2, 3]
 * 示例2:
 * <p>
 * 输入：[1, 1, 1, 1, 2]
 * 输出：[1, 2]
 * 提示：
 * <p>
 * 链表长度在[0, 20000]范围内。
 * 链表元素在[0, 20000]范围内。
 * 进阶：
 * <p>
 * 如果不得使用临时缓冲区，该怎么解决？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-node-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/09/13
 */
public class RemoveDuplicateNodes {

    /**
     * 使用Set保存不重复的节点的值
     * 枚举待移除节点的上一个节点（直接枚举待移除节点会最后一个节点发现删除不了）
     *
     * @param head
     * @return
     */
   /* public ListNode removeDuplicateNodes(ListNode head) {

        if (head == null) return null;

        ListNode ans = head;
        HashSet<Integer> set = new HashSet<>();
        set.add(head.val);

        while (head.next != null) {
            //枚举待移除节点的上一个节点
            ListNode cur = head.next;
            if (set.add(cur.val)) {
                head = head.next;
            } else {
                head.next = head.next.next;
            }
        }
        return ans;
    }*/

    /**
     * o(1)空间复杂度，但是o(n^2)空间复杂度
     *
     * @param head
     * @return
     */
    public ListNode removeDuplicateNodes(ListNode head) {
        ListNode ans = head;

        while (head!=null){
            int comp = head.val;
            ListNode temp = head;
            while (temp.next!=null){
                ListNode cur = temp.next;
                if (comp==cur.val){
                    temp.next = temp.next.next;
                }else {
                    temp = temp.next;
                }
            }
            head=head.next;
        }
        return ans;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(2);
        ListNode n6 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        new RemoveDuplicateNodes().removeDuplicateNodes(n1);
    }
}
