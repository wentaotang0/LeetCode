package algorithms.tree.binarytree;

import algorithms.linkedlist.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author twt
 * @description 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * <p>
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * Tree 1                     Tree 2
 * 1                         2
 * / \                       / \
 * 3   2                     1   3
 * /                           \   \
 * 5                             4   7
 * 输出:
 * 合并后的树:
 * 3
 * / \
 * 4   5
 * / \   \
 * 5   4   7
 * 注意: 合并必须从两个树的根节点开始。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-binary-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/11/08
 */
public class MergeTrees {

    /**
     * DFS
     *
     * @param t1
     * @param t2
     * @return
     */
    /*public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if (t1 == null) return t2;
        if (t2 == null) return t1;
        TreeNode node = new TreeNode(t1.val + t2.val);
        node.left = mergeTrees(t1.left, t2.left);
        node.right = mergeTrees(t1.right, t2.right);
        return node;
    }*/


    /**
     * BFS
     *
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;

        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        Queue<TreeNode> merge = new LinkedList<>();
        q1.add(t1);
        q2.add(t2);
        TreeNode mergeRoot = new TreeNode(t1.val + t2.val);
        merge.add(mergeRoot);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode node1 = q1.poll();
            TreeNode node2 = q2.poll();
            TreeNode node = merge.poll();
            TreeNode l1 = node1.left;
            TreeNode l2 = node2.left;
            TreeNode r1 = node1.right;
            TreeNode r2 = node2.right;
            if (l1 != null || l2 != null) {
                if (l1 != null && l2 != null) {
                    TreeNode left = new TreeNode(l1.val + l2.val);
                    node.left = left;
                    q1.add(l1);
                    q2.add(l2);
                    merge.add(left);
                } else if (l1 == null) {
                    node.left = l2;
                } else {
                    node.left = l1;
                }
            }

            if (r1 != null || r2 != null) {
                if (r1 != null && r2 != null) {
                    TreeNode mergeNode = new TreeNode(r1.val + r2.val);
                    node.right = mergeNode;
                    q1.add(r1);
                    q2.add(r2);
                    merge.add(mergeNode);
                } else if (r1 == null) {
                    node.right = r2;
                } else {
                    node.right = r1;
                }
            }
        }
        return mergeRoot;
    }

}


