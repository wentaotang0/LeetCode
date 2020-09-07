package algorithms.linkedlist;

/**
 * @author twt
 * @description 实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：单向链表a->b->c->d->e->f中的节点c
 * 结果：不返回任何数据，但该链表变为a->b->d->e->f
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-middle-node-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/09/07
 */
public class DeleteNode {


    /**
     * 循环删除
     * 整个过程可以理解为要删除[1,2,3,4]中的2。3把2覆盖，4把3覆盖最后变为[1,3,4]
     *
     * @param node 要删除的节点
     */
    public void deleteNode(ListNode node) {


        while (true) {
            node.val = node.next.val;

            if (node.next.next == null) {
                node.next = null;
                return;
            }
            node = node.next;//当前节点往前走一步或者当前节点的上一个节点指向当前节点的下一个节点

        }
    }

    /**
     * 让该节点的上一个节点指向该节点的下一个节点
     *
     * @param node
     */
   /* public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }*/
}
